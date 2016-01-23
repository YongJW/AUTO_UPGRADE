/*
 * Copyright (c) 2015 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

define(['app/dluxDemo/dluxDemo.module'],function(dluxDemoApp) {


  dluxDemoApp.register.factory('dluxDemoSvc', function($http, ENV) {
    var svc = {
      base: ENV.getBaseURL("MD_SAL") + "/restconf/"
    };

    /*
     * You can define all of your REST API interactions here.
     */

    return svc;
  });

  dluxDemoApp.register.factory('ConfigRestangular', function(Restangular, ENV) {
    return Restangular.withConfig(function(RestangularConfig) {
      RestangularConfig.setBaseUrl(ENV.getBaseURL("MD_SAL"));
    });
  });
  
  dluxDemoApp.register.factory('ConfigRest',function(ConfigRestangular){
	  var svc = {
		  base : function(){
			  return ConfigRestangular.one('restconf').one('config').one('BootCamp-UG-cfg:configurations');
		  },
		  data : null
	  };
	  
	  svc.getConfig = function(node){
		  return svc.base().get();
	  };
	  return svc;
  });
  
});
