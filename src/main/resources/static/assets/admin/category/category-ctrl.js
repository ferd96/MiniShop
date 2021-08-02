app.controller("product-ctrl",function($scope,$http){
    $scope.items=[];
    $scope.form ={};
    $scope.cates=[];
    $scope.initialize = function(){
        //load products
        $http.get("/rest/products").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                item.createDate = new Date(item.createDate)
            })
        });

        //load categories
        $http.get("/rest/categories").then(resp => {
            $scope.cates = resp.data;
            
        });
    }

    $scope.initialize();

    $scope.reset = function(){
        $scope.form = {
            createDate:new Date(),
            image:"",
            available:true
        };
    }

    $scope.edit = function(item){
    	$scope.form = angular.copy(item);
    	$(".nav-tabs a:eq(0)").tab('show')
    }

    $scope.create = function(){
    	var item = angular.copy($scope.form);
      
            
            $http.post(`/rest/products`,item).then(resp => {
            resp.data.createDate = new Date(resp.data.createDate)
                $scope.items.push(resp.data);
                $scope.reset();
                alert("Thêm Mới Sản Phẩm Thành CÔng!");
            }).catch(error => {
                alert("Lỗi Thêm Mới Sản Phẩm !");
                console.log("Error",error);
            });
        
    }

    $scope.update = function(){
    	var item = angular.copy($scope.form);
    	$http.put(`/rest/products/${item.id}`,item).then(resp =>{
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.items[index] = item;
            alert("Cập Nhật Sản Phẩm Thành Công!");

        }).catch(error => {
            alert("Lỗi Cập Nhật Sản Phẩm!");
            console.log("Error",error);
        });
    }

    $scope.delete = function(item){
    	$http.delete(`/rest/products/${item.id}`).then(resp =>{
            var index = $scope.items.findIndex( p => p.id == item.id);
            $scope.items.splice(index,1);
            $scope.reset();
            alert("Xoá sản phẩm thành Công!");
        }).catch(error =>{
            alert("Lỗi Xoá Sản Phẩm");
            console.log("Error",error);
        });
    }

    $scope.imageChanged = function(files){
        var data  = new FormData();
        data.append('file',files[0]);
        $http.post('/rest/upload/featured/',data,{
            transformRequest: angular.identity,
            headers:{'Content-Type':undefined}
        }).then(resp => {
            $scope.form.image = resp.data.name;
            
        }).catch(error => {
            alert("Lỗi Upload Hình Ảnh");
            console.log("Error",error);
        })
    }

    $scope.pager = {
        page:0 ,
        size:5 ,
        get items(){
            var start = this.page * this.size;
            return $scope.items.slice(start,start + this.size);
        },
        get count(){
            return Math.ceil(1.0 * $scope.items.length / this.size);
        },
        first(){
            this.page= 0;
        },
        prev(){
            this.page--;
            if(this.page<0){
                this.last();
            }
        },
        next(){
            this.page++;
            if(this.page>=this.count){
                this.first();
            }
        },
        last(){
            this.page = this.count-1;
        }
    }
});