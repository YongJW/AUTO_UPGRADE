/*
 * Copyright (c) 2015 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

define(['app/dluxDemo/dluxDemo.module','app/dluxDemo/dluxDemo.services'], function(dluxDemoApp) {

  dluxDemoApp.register.controller('dluxDemoCtrl', ['$scope', '$rootScope', 'dluxDemoSvc', function($scope, $rootScope, dluxDemoSvc) {

    $rootScope['section_logo'] = ''; // Add your topbar logo location here such as 'assets/images/logo_topology.gif'
    $scope.dluxDemoInfo = {};
    $scope.data = "dluxDemo";
  }]);

  dluxDemoApp.register.controller('restConfigCtrl',function($scope,ConfigRest,$interval){
	  $scope.isSent = true;
	  $scope.isNon = false;
	  $scope.current="";
	  $scope.prev="";
	  $scope.timeid="";
	  ConfigRest.getConfig().then(function(data){
			$scope.data = data;
			for(var i = 0;i < data.configurations.configuration.length;i ++){
				if(data.configurations.configuration[i]['type'] == 'BootCamp-UG-cfg:switch'){
					$scope.current=data.configurations.configuration[i]['current-status'];
					$scope.prev=data.configurations.configuration[i]['prev-status'];
				}
			}
			$scope.isSent = false;
			$scope.isNon = true;
	  },function(response){
		  $scope.isSent = true;
		  $scope.isNon = false;
		  $scope.data = ConfigRest.getConfig();
	  });
	  $scope.$watch('userConfig',function(){
		  	console.log('current event!!!!');
	  });
	  $scope.autoGrade = function(config){
		  	console.log('autoUpgrade Func!!!');
		  	if(!$scope.isSent){
		  		return;
		  	}
		  	
		  	ConfigRest.base().customPUT(
		  			{
		  				"configurations":{
		  					"configuration":
		  						[
		  							{
		  								"name":"controller-config",
		  								"type":"cfgpoint",
		  								"repository":"/home/mvn2",
		  								"file":"pom.xml",
		  								"protocol":"SSH",
		  								"ip-version":"ipv4",
		  								"host":"localhost",
		  								"port":"22",
		  								"username":"root",
		  								"password":"admin"
		  							},
		  							{
		  								"name": config.name,
		  								"host": config.host,
		  								"isolation-policy": config.isolationPolicy,
		  								"username": config.username,
		  								"repository": config.repository,
		  								"ip-version": "ipv4",
		  								"port": config.port,
		  								"protocol": "SSH",
		  								"password": config.password,
		  								"type": config.type,
		  								"file": config.file
		  							}
		  						]
		  				}
		  			},
		  			null,
		  			null,
		  			{'Content-Type':'application/yang.data+json'}).then(function(){
		  				$scope.isSent = false;
		  				$scope.isNon = true;
		  				$scope.timeid = $interval(function(){$scope.showStep();},1000);
		  			},function(response){
		  				alert("upgrade Command Sent Fail!Check argument!");
		  				console.log("Error with status code", response.status);
		  			});
	  };
	  
	  $scope.showStep = function(){
		  ConfigRest.base().get().then(function(data){
			  console.log('flush Step!');
			  for(var i = 0;i < data.configurations.configuration.length;i ++){
				  if(data.configurations.configuration[i]['type'] == 'BootCamp-UG-cfg:switch'){
					  $scope.current=data.configurations.configuration[i]['current-status'];
					  $scope.prev=data.configurations.configuration[i]['prev-status'];
					  if($scope.current == 'SUCCESS'){
						  console.log('clear interval');
						  $interval.cancel($scope.timeid);
					  }
				  }
			  }
			 
		  });
	  };
	  
  });


});
