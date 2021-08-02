var app = angular.module("admin-app",["ngRoute"]);

app.config(function($routeProvider){
    $routeProvider
    .when("/product",{
        templateUrl:"/assets/admin/product/index.html",
        controller:"product-ctrl"
    })
    .when("/authorize",{
        templateUrl:"/assets/admin/category/index.html",
        controller:"category-ctrl"
    })
    .when("/unauthorized",{
        templateUrl:"/assets/admin/authority/unauthorized.html",
        controller:"authority-ctrl"
    })
    .otherwise({
        templateUrl:"<h1 class='text-center'> FPT Polytechnic Adminstration</h1>"
    });
})