/*
 * Copyright (c) 2015 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

define(['angularAMD', 'app/routingConfig', 'app/core/core.services', 'common/config/env.module'], function(ng) {
  var dluxDemoApp = angular.module('app.dluxDemo', ['app.core', 'ui.router.state','config']);

  dluxDemoApp.config(function($stateProvider, $compileProvider, $controllerProvider, $provide, NavHelperProvider, $translateProvider) {
    dluxDemoApp.register = {
      controller : $controllerProvider.register,
      directive : $compileProvider.directive,
      factory : $provide.factory,
      service : $provide.service

    };


    NavHelperProvider.addControllerUrl('app/dluxDemo/dluxDemo.controller');
    NavHelperProvider.addToMenu('dluxDemo', {
     "link" : "#/dluxDemo",
     "active" : "main.dluxDemo",
     "title" : "AutoUpgrade",
     "icon" : "",  // Add navigation icon css class here
     "page" : {
        "title" : "dluxDemo",
        "description" : "dluxDemo"
     }
    });

    var access = routingConfig.accessLevels;

    $stateProvider.state('main.dluxDemo', {
        url: 'dluxDemo',
        access: access.admin,
        views : {
            'content' : {
                templateUrl: 'src/app/dluxDemo/dluxDemo.tpl.html',
                controller: 'restConfigCtrl'
            }
        }
    });

  });

  return dluxDemoApp;
});
