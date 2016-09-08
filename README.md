 ![image](https://github.com/jeasonlzy0216/Screenshots/blob/master/okhttputils/logo3.png)

# OkHttpUtils

### 封装了okhttp的网络框架，支持大文件上传下载，上传进度回调，下载进度回调，表单上传（多文件和多参数一起上传），链式调用，可以自定义返回对象，支持Https和自签名证书，支持cookie自动管理，支持四种缓存模式缓存网络数据，支持301、302重定向，扩展了统一的上传管理和下载管理功能

该项目参考了以下项目：

 * [https://github.com/hongyangAndroid/okhttp-utils](https://github.com/hongyangAndroid/okhttp-utils)  
 * [https://github.com/yanzhenjie/NoHttp](https://github.com/Y0LANDA/NoHttp) 
 * [https://github.com/wyouflf/xUtils](https://github.com/wyouflf/xUtils) 

在此特别感谢上述作者，喜欢原作的可以去使用原项目。同时欢迎大家下载体验本项目，如果使用过程中遇到什么问题，欢迎反馈。

## 联系方式
 * 邮箱地址： liaojeason@126.com
 * QQ群： 489873144 （建议使用QQ群，邮箱使用较少，可能看的不及时）
 * 本群旨在为使用我的github项目的人提供方便，如果遇到问题欢迎在群里提问。个人能力也有限，希望一起学习一起进步。

## 演示


 ![image](https://github.com/jeasonlzy0216/Screenshots/blob/master/okhttputils/demo7.gif)![image](https://github.com/jeasonlzy0216/Screenshots/blob/master/okhttputils/demo8.gif)![image](https://github.com/jeasonlzy0216/Screenshots/blob/master/okhttputils/demo11.gif)![image](https://github.com/jeasonlzy0216/Screenshots/blob/master/okhttputils/demo9.gif)![image](https://github.com/jeasonlzy0216/Screenshots/blob/master/okhttputils/demo10.gif)![image](https://github.com/jeasonlzy0216/Screenshots/blob/master/okhttputils/demo12.gif)


## 1.用法

> * 为了方便大家使用，更加通俗的理解http的网络协议，建议做网络请求的时候，对每个请求抓包后查看请求信息和响应信息。
> * 如果是 Windows 操作系统，可以使用 `Fiddler` 对手机的请求进行抓包查看。
> * 如果是 Mac OS  操作系统，可以使用 `Charles` 对手机的请求进行抓包查看。
> * 具体的下载地址和抓包配置方法，我这就不提供了，请自行百度或谷歌。


   对于Eclipse不能运行项目的，提供了apk供直接运行
   
### 或者点击下载Demo [okhttputils_v1.8.0.apk](https://github.com/jeasonlzy0216/OkHttpUtils/blob/master/okhttputils_v1.8.0.apk?raw=true)。

   本项目Demo的网络请求是我自己的服务器，有时候可能不稳定，网速比较慢时请耐心等待。。

 * 对于Android Studio的用户，可以选择添加:
```java
    compile 'com.lzy.net:okhttputils:1.8.0'  //可以单独使用，不需要依赖下方的扩展包
	compile 'com.lzy.net:okhttpserver:1.0.2' //扩展了下载管理和上传管理，根据需要添加
    
    或者
    
	compile 'com.lzy.net:okhttputils:+'  //版本号使用 + 可以自动引用最新版
	compile 'com.lzy.net:okhttpserver:+' //版本号使用 + 可以自动引用最新版
```

 * 对于Eclipse的用户，可以选择添加 `/jar` 目录下的:
```java
	okhttputils-1.8.0.jar
	okhttpserver-1.0.2.jar
```
 * 如果是以jar包的形式引入`okhttpserver`,需要在清单文件中额外注册一个服务
```java
    <service android:name="com.lzy.okhttpserver.download.DownloadService"/>
```
 * 如果只是用了`okhttputils`的jar,没有使用`okhttpserver`的jar,那么不需要注册上面的服务

#### 其中的图片选择是我的另一个开源项目，完全仿微信的图片选择库，自带 矩形图片裁剪 和 圆形图片裁剪 功能，有需要的可以去下载使用，附上地址：[https://github.com/jeasonlzy0216/ImagePicker](https://github.com/jeasonlzy0216/ImagePicker)
#### 其中的九宫格控件也是我的开源项目,类似QQ空间，微信朋友圈，微博主页等，展示图片的九宫格控件，自动根据图片的数量确定图片大小和控件大小，使用Adapter模式设置图片，对外提供接口回调，使用接口加载图片,支持任意的图片加载框架,如 Glide,ImageLoader,Fresco,xUtils3,Picasso 等，支持点击图片全屏预览大图。附上地址：[https://github.com/jeasonlzy0216/NineGridView](https://github.com/jeasonlzy0216/NineGridView)
	
## 2.使用注意事项
 * `okhttputils`使用的`okhttp`的版本是最新的 3.4.1 版本，和以前的 2.x 的版本可能会存在冲突。
 * `okhttpserver`是对`okhttputils`的扩展，统一了下载管理和上传管理，对项目有需要做统一下载的可以考虑使用该扩展，不需要的可以直接使用`okhttputils`即可。
 * 对于缓存模式使用，需要与返回对象相关的所有`javaBean`必须实现`Serializable`接口，否者会报`NotSerializableException`。
 * 使用缓存时，如果不指定`cacheKey`，默认是用url带参数的全路径名为`cacheKey`。
 * 使用该网络框架时，必须要在 Application 中做初始化 `OkHttpUtils.init(this);`。

## 3.OkHttpUtils 目前支持
* 一般的 get,post,put,delete,head,options请求
* 基于Post的大文本数据上传
* 多文件和多参数统一的表单上传
* 支持一个key上传一个文件，也可以一个Key上传多个文件
* 大文件下载和下载进度回调
* 大文件上传和上传进度回调
* 支持cookie的内存存储和持久化存储，支持传递自定义cookie
* 支持304缓存协议，扩展四种本地缓存模式,并且支持缓存时间控制
* 支持301、302重定向
* 支持链式调用
* 支持可信证书和自签名证书的https的访问,支持双向认证
* 支持根据Tag取消请求
* 支持自定义泛型Callback，自动根据泛型返回对象

## 4.OkHttpServer 扩展功能

### 4.1 统一的文件下载管理(DownloadManager)：
 * 结合OkHttpUtils的request进行网络请求,支持与OkHttpUtils保持相同的全局公共参数,同时支持请求传递参数
 * 支持断点下载，支持突然断网,强杀进程后,断点依然有效
 * 支持 下载 暂停 等待 停止 出错 完成 六种下载状态
 * 所有下载任务按照taskKey区分,切记不同的任务必须使用不一样的key,否者断点会发生覆盖
 * 相同的下载url地址如果使用不一样的taskKey,也会认为是两个下载任务
 * 默认同时下载数量为3个，默认下载路径`/storage/emulated/0/download`，下载路径和下载数量都可以在代码中配置
 * 下载文件名可以自己定义,也可以不传,框架自动解析响应头或者url地址获得文件名,如果都没获取到,使用default作为文件名
 * 下载管理使用了服务提高线程优先级，避免后台下载时被系统回收
 
### 4.2 统一的文件上传管理(UploadManager)
 * 结合OkHttpUtils的request进行网络请求,支持与OkHttpUtils保持相同的全局公共参数,同时支持请求传递参数
 * 上传只能使用`Post`, `Put`, `Delete`, `Options` 这四种请求,不支持`Get`, `Head`
 * 该上传管理为简单管理，不支持断点续传或分片上传，只是简单的将所有上传任务使用线程池进行了统一管理
 * 默认同时上传数量为1个,该数列可以在代码中配置修改

## 一、全局配置
一般在 Aplication，或者基类中，只需要调用一次即可，可以配置调试开关，全局的超时时间，公共的请求头和请求参数等信息
```java
    @Override
    public void onCreate() {
        super.onCreate();

        //---------这里给出的是示例代码,告诉你可以这么传,实际使用的时候,根据需要传,不需要就不传-------------//
        HttpHeaders headers = new HttpHeaders();
        headers.put("commonHeaderKey1", "commonHeaderValue1");    //header不支持中文
        headers.put("commonHeaderKey2", "commonHeaderValue2");
        HttpParams params = new HttpParams();
        params.put("commonParamsKey1", "commonParamsValue1");     //param支持中文,直接传,不要自己编码
        params.put("commonParamsKey2", "这里支持中文参数");
        //-----------------------------------------------------------------------------------//

        //必须调用初始化
        OkHttpUtils.init(this);

        //以下设置的所有参数是全局参数,同样的参数可以在请求的时候再设置一遍,那么对于该请求来讲,请求中的参数会覆盖全局参数
        //好处是全局参数统一,特定请求可以特别定制参数
        try {
            //以下都不是必须的，根据需要自行选择,一般来说只需要 debug,缓存相关,cookie相关的 就可以了
            OkHttpUtils.getInstance()

                    //打开该调试开关,控制台会使用 红色error 级别打印log,并不是错误,是为了显眼,不需要就不要加入该行
                    .debug("OkHttpUtils")

                    //如果使用默认的 60秒,以下三行也不需要传
                    .setConnectTimeout(OkHttpUtils.DEFAULT_MILLISECONDS)  //全局的连接超时时间
                    .setReadTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS)     //全局的读取超时时间
                    .setWriteTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS)    //全局的写入超时时间

                    //可以全局统一设置缓存模式,默认就是Default,可以不传,具体其他模式看 github 介绍 https://github.com/jeasonlzy0216/
                    .setCacheMode(CacheMode.DEFAULT)

                    //可以全局统一设置缓存时间,默认永不过期,具体使用方法看 github 介绍
                    .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)

                    //如果不想让框架管理cookie,以下不需要
//                .setCookieStore(new MemoryCookieStore())                //cookie使用内存缓存（app退出后，cookie消失）
                    .setCookieStore(new PersistentCookieStore())          //cookie持久化存储，如果cookie不过期，则一直有效

                    //可以设置https的证书,以下几种方案根据需要自己设置,不需要不用设置
//                    .setCertificates()                                  //方法一：信任所有证书
//                    .setCertificates(getAssets().open("srca.cer"))      //方法二：也可以自己设置https证书
//                    .setCertificates(getAssets().open("aaaa.bks"), "123456", getAssets().open("srca.cer"))//方法三：传入bks证书,密码,和cer证书,支持双向加密

                    //可以添加全局拦截器,不会用的千万不要传,错误写法直接导致任何回调不执行
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        return chain.proceed(chain.request());
//                    }
//                })

                    //这两行同上,不需要就不要传
                    .addCommonHeaders(headers)                                         //设置全局公共头
                    .addCommonParams(params);                                          //设置全局公共参数
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

## 二、普通请求

#### 0.写在开始的话,`callback`回调默认只需要复写`onSuccess`,并不代表所有的回调都只走这一个,实际开发中,错误回调并没有成功回调使用频繁,所以`callback`的失败回调`onError`并没有声明为抽象的,如果有需要,请自行复写,不要再问我为什么回调没有执行啊,既然`onSuccess`没有执行,那么一定是出错了回调了`onError`

callback一共有以下 10 个回调,除`onSuccess`必须实现以外,其余均可以按需实现,每个方法参数详细说明,请看下面第6点:

 * parseNetworkResponse():解析网络返回的数据回调
 * parseNetworkFail():解析网络失败的数据回调
 * onBefore():网络请求真正执行前回调
 * onSuccess():网络请求成功的回调
 * onCacheSuccess():缓存读取成功的回调
 * onError():网络请求失败的回调
 * onCacheError():网络缓存读取失败的回调
 * onAfter():网络请求结束的回调,无论成功失败一定会执行
 * upProgress():上传进度的回调
 * downloadProgress():下载进度的回调

### Callback回调具有如下顺序,虽然顺序写的很复杂,但是理解后,是很简单,并且合情合理的
#### 1).无缓存模式 CacheMode.NO_CACHE
> 网络请求成功  onBefore -> parseNetworkResponse -> onSuccess -> onAfter<br>
> 网络请求失败  onBefore -> parseNetworkFail     -> onError   -> onAfter<br>

#### 2).默认缓存模式,遵循304头 CacheMode.DEFAULT
> 网络请求成功,服务端返回非304  onBefore -> parseNetworkResponse -> onSuccess -> onAfter<br>
> 网络请求成功服务端返回304    onBefore -> onCacheSuccess       -> onAfter<br>
> 网络请求失败               onBefore -> parseNetworkFail     -> onError   -> onAfter<br>
 
#### 3).请求网络失败后读取缓存 CacheMode.REQUEST_FAILED_READ_CACHE
> 网络请求成功,不读取缓存    onBefore -> parseNetworkResponse -> onSuccess -> onAfter<br>
> 网络请求失败,读取缓存成功  onBefore -> parseNetworkFail -> onError -> onCacheSuccess -> onAfter<br>
> 网络请求失败,读取缓存失败  onBefore -> parseNetworkFail -> onError -> onCacheError   -> onAfter<br>

#### 4).如果缓存不存在才请求网络，否则使用缓存 CacheMode.IF_NONE_CACHE_REQUEST
> 已经有缓存,不请求网络  onBefore -> onCacheSuccess -> onAfter<br>
> 没有缓存请求网络成功   onBefore -> onCacheError   -> parseNetworkResponse -> onSuccess -> onAfter<br>
> 没有缓存请求网络失败   onBefore -> onCacheError   -> parseNetworkFail     -> onError   -> onAfter<br>

#### 5).先使用缓存，不管是否存在，仍然请求网络 CacheMode.FIRST_CACHE_THEN_REQUEST
> 无缓存时,网络请求成功  onBefore -> onCacheError   -> parseNetworkResponse -> onSuccess -> onAfter<br>
> 无缓存时,网络请求失败  onBefore -> onCacheError   -> parseNetworkFail     -> onError   -> onAfter<br>
> 有缓存时,网络请求成功  onBefore -> onCacheSuccess -> parseNetworkResponse -> onSuccess -> onAfter<br>
> 有缓存时,网络请求失败  onBefore -> onCacheSuccess -> parseNetworkFail     -> onError   -> onAfter<br>

### 1.基本的网络请求
```java
OkHttpUtils.get(Urls.URL_METHOD)     // 请求方式和请求url
	.tag(this)                       // 请求的 tag, 主要用于取消对应的请求
	.cacheKey("cacheKey")            // 设置当前请求的缓存key,建议每个不同功能的请求设置一个
	.cacheMode(CacheMode.DEFAULT)    // 缓存模式，详细请看缓存介绍
	.execute(new StringCallback() {
		@Override
		public void onSuccess(String s, Call call, Response response) {
		    // s 即为所需要的结果
		}
	});
```
### 2.请求 Bitmap 对象
```java
OkHttpUtils.get(Urls.URL_IMAGE)//
	.tag(this)//
	.execute(new BitmapCallback() {
	    @Override
	    public void onSuccess(Bitmap bitmap, Call call, Response response) {
		    // bitmap 即为返回的图片数据
	    }
	});
```
### 3.请求 文件下载
```java
OkHttpUtils.get(Urls.URL_DOWNLOAD)//
	.tag(this)//
	.execute(new FileCallback("file.jpg") {  //文件下载时，需要指定下载的文件目录和文件名
	    @Override
	    public void onSuccess(File file, Call call, Response response) {
		    // file 即为文件数据，文件保存在指定目录
	    }
	    
	    @Override
        public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
            //这里回调下载进度(该回调在主线程,可以直接更新ui)
        }
	});
```
### 4.普通Post，直接上传String类型的文本
一般此种用法用于与服务器约定的数据格式，当使用该方法时，params中的参数设置是无效的，所有参数均需要通过需要上传的文本中指定，此外，额外指定的header参数仍然保持有效。
```java
OkHttpUtils.post(Urls.URL_TEXT_UPLOAD)//
	.tag(this)//
	.upString("这是要上传的长文本数据！")//
	.execute(new StringCallback() {
	    @Override
	    public void onSuccess(String s, Call call, Response response) {
			//上传成功
	    }
	    
	    @Override
        public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
            //这里回调上传进度(该回调在主线程,可以直接更新ui)
        }
	});
```

### 5.普通Post，直接上传Json类型的文本
该方法与postString没有本质区别，只是数据格式是json,一般来说，需要自己创建一个实体bean或者一个map，把需要的参数设置进去，然后通过三方的Gson或者fastjson转换成json字符串，最后直接使用该方法提交到服务器。
```java
HashMap<String, String> params = new HashMap<>();
params.put("key1", "value1");
params.put("key2", "这里是需要提交的json格式数据");
params.put("key3", "也可以使用三方工具将对象转成json字符串");
params.put("key4", "其实你怎么高兴怎么写都行");
JSONObject jsonObject = new JSONObject(params);
        
OkHttpUtils.post(Urls.URL_TEXT_UPLOAD)//
	.tag(this)//
	.upJson(jsonObject.toString())//
	.execute(new StringCallback() {
	    @Override
	    public void onSuccess(String s, Call call, Response response) {
			//上传成功
	    }
	    
	    	    
	    @Override
        public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
            //这里回调上传进度(该回调在主线程,可以直接更新ui)
        }
	});
```

### 6.https请求(证书可以在全局初始化的时候设置,不用每次请求设置一遍)
```java
OkHttpUtils.get("https://kyfw.12306.cn/otn")//
        .tag(this)//
        .headers("Connection", "close")           //如果对于部分自签名的https访问不成功，需要加上该控制头
        .headers("header1", "headerValue1")//
        .params("param1", "paramValue1")//
//      .setCertificates()                             //方法一：信任所有证书
//      .setCertificates(getAssets().open("srca.cer")) //方法二：也可以设置https证书
        //方法三：传入bks证书,密码,和cer证书,支持双向加密
//      .setCertificates(getAssets().open("aaaa.bks"), "123456", getAssets().open("srca.cer"))
        .execute(new HttpsCallBack(this));
```
### 7.请求功能的所有配置讲解

以下代码包含了以下内容：

 * 一次普通请求所有能配置的参数，真实使用时不需要配置这么多，按自己的需要选择性的使用即可
 * 多文件和多参数的表单上传，同时支持进度监听
 * 自签名网站https的访问，调用`setCertificates`方法即可
 * 为单个请求设置超时，比如涉及到文件的需要设置读写等待时间多一点。
 * Cookie一般情况下只需要在初始化的时候调用`setCookieStore`即可实现cookie的自动管理，如果特殊业务需要，需要手动额外向服务器传递自定义的cookie，可以在每次请求的时候调用`addCookie`方法，该方法提供了3个重载形式，可以根据自己的需要选择使用。

```java
OkHttpUtils.get(Urls.URL_METHOD) // 请求方式和请求url, get请求不需要拼接参数，支持get，post，put，delete，head，options请求
    .tag(this)               // 请求的 tag, 主要用于取消对应的请求
    .connTimeOut(10000)      // 设置当前请求的连接超时时间
    .readTimeOut(10000)      // 设置当前请求的读取超时时间
    .writeTimeOut(10000)     // 设置当前请求的写入超时时间
    .cacheKey("cacheKey")    // 设置当前请求的缓存key,建议每个不同功能的请求设置一个
    .cacheTime(5000)         // 缓存的过期时间,单位毫秒
    .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST) // 缓存模式，详细请看第四部分，缓存介绍
    .setCertificates(getAssets().open("srca.cer")) // 自签名https的证书，可变参数，可以设置多个
    .addInterceptor(interceptor)            // 添加自定义拦截器
    .headers("header1", "headerValue1")     // 添加请求头参数
    .headers("header2", "headerValue2")     // 支持多请求头参数同时添加
    .params("param1", "paramValue1")        // 添加请求参数
    .params("param2", "paramValue2")        // 支持多请求参数同时添加
    .params("file1", new File("filepath1")) // 可以添加文件上传
    .params("file2", new File("filepath2")) // 支持多文件同时添加上传
	.addUrlParams("key", List<String> values) //这里支持一个key传多个参数
	.addFileParams("key", List<File> files)	//这里支持一个key传多个文件
	.addFileWrapperParams("key", List<HttpParams.FileWrapper> fileWrappers)//这里支持一个key传多个文件
	.addCookie("aaa", "bbb")	// 这里可以传递自己想传的Cookie
    .addCookie(cookie)			// 可以自己构建cookie
    .addCookies(cookies)		// 可以一次传递批量的cookie
     //这里给出的泛型为 ServerModel，同时传递一个泛型的 class对象，即可自动将数据结果转成对象返回
    .execute(new DialogCallback<ServerModel>(this, ServerModel.class) {
		@Override
		public void onBefore(BaseRequest request) {
		    // UI线程 请求网络之前调用
		    // 可以显示对话框，添加/修改/移除 请求参数
		}
	
		@Override
		public ServerModel parseNetworkResponse(Response response) throws Exception{
		    // 子线程，可以做耗时操作
		    // 根据传递进来的 response 对象，把数据解析成需要的 ServerModel 类型并返回
		    // 可以根据自己的需要，抛出异常，在onError中处理
		    return null;
		}
		
		@Override
        public void parseNetworkFail(Call call, IOException e) {
            // 子线程，可以做耗时操作
        	// 用于网络错误时在子线程中执行数据耗时操作,子类可以根据自己的需要重写此方法
        }
	
		@Override
		public void onSuccess(ServerModel serverModel, Call call, Response response) {
		    // UI 线程，请求成功后回调
		    // ServerModel 返回泛型约定的实体类型参数
		    // call        本次网络的请求信息，如果需要查看请求头或请求参数可以从此对象获取
		    // response    本次网络访问的结果对象，包含了响应头，响应码等		
		}
		
		@Override
		public void onCacheSuccess(ServerModel serverModel, Call call) {
		    // UI 线程，缓存读取成功后回调
		    // serverModel 返回泛型约定的实体类型参数
		    // call        本次网络的请求信息
		}
	
		@Override
		public void onError(Call call, Response response, Exception e) {
		    // UI 线程，请求失败后回调
		    // call        本次网络的请求对象，可以根据该对象拿到 request
		    // response    本次网络访问的结果对象，包含了响应头，响应码等		    
		    // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 404,或大于等于500
		}
	
		@Override
		public void onCacheError(Call call, Exception e) {
		    // UI 线程，读取缓存失败后回调
			// call        本次网络的请求对象，可以根据该对象拿到 request
		    // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 404,或大于等于500
		}
	
		@Override
		public void onAfter(ServerModel serverModel, Exception e) {
		    // UI 线程，请求结束后回调，无论网络请求成功还是失败，都会调用，可以用于关闭显示对话框
		    // ServerModel 返回泛型约定的实体类型参数，如果网络请求失败，该对象为　null
		    // e           本次网络访问的异常信息，如果服务器内部发生了错误，响应码为 404,或大于等于500
		}
	
		@Override
		public void upProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
		    // UI 线程，文件上传过程中回调，只有请求方式包含请求体才回调（GET,HEAD不会回调）
		    // currentSize  当前上传的大小（单位字节）
		    // totalSize 　 需要上传的总大小（单位字节）
		    // progress     当前上传的进度，范围　0.0f ~ 1.0f
		    // networkSpeed 当前上传的网速（单位秒）
		}
	
		@Override
		public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
		    // UI 线程，文件下载过程中回调
		    //参数含义同　上传相同
		}
    });
```
### 8.取消请求
每个请求前都设置了一个参数`tag`，取消则通过` OkHttpUtils.cancel(tag)`执行。
例如：在Activity中，当Activity销毁取消请求，可以在onDestory里面统一取消。
```java
	@Override
	protected void onDestroy() {
	    super.onDestroy();

		//根据 Tag 取消请求
	    OkHttpUtils.getInstance().cancelTag(this);
	}
```
### 9.同步的请求
execute方法不传入callback即为同步的请求，返回`Response`对象，需要自己解析
```java
	Response response = OkHttpUtils.get("http://www.baidu.com")//
					                .tag(this)//
					                .headers("aaa", "111")//
					                .params("bbb", "222")
									.execute();
```
### 10.参数的顺序
添加header和param的方法各有三个地方,在提交的时候,他们是有顺序的,如果对提交顺序有需要的话,请注意这里

 * 第一个地方,全局初始化时,使用`OkHttpUtils.getInstance().addCommonHeaders()`,`OkHttpUtils.getInstance().addCommonParams()` 添加

```java
    HttpHeaders headers = new HttpHeaders();
    headers.put("HKAAA", "HVAAA");
    headers.put("HKBBB", "HVBBB");
    HttpParams params = new HttpParams();
    params.put("PKAAA", "PVAAA"); 
    params.put("PKBBB", "PVBBB");
    
    OkHttpUtils.getInstance()
               .addCommonHeaders(headers) //设置全局公共头
               .addCommonParams(params);  //设置全局公共参数
```

 * 第二个地方,`callback`的`onBefore`方法中添加
 
```java
    public abstract class CommonCallback<T> extends AbsCallback<T> {
        @Override
        public void onBefore(BaseRequest request) {
            super.onBefore(request);
            
            request.headers("HKCCC", "HVCCC")//
                    .headers("HKDDD", "HVDDD")//
                    .params("PKCCC", "PVCCC")//
                    .params("PKDDD", "PVDDD")//
        }
    }
```

 * 第三个地方,执行网络请求的时候添加

```java
    OkHttpUtils.get(Urls.URL_METHOD)//
            .tag(this)//
            .headers("HKEEE", "HVEEE")//
            .headers("HKFFF", "HVFFF")//
            .params("PKEEE", "PVEEE")//
            .params("PKFFF", "PVFFF")//
            .execute(new MethodCallBack<>(this, ServerModel.class));
```
 
 那么,最终执行请求的参数的添加顺序为
 
> * Header顺序: HKAAA -> HKBBB -> HKEEE -> HKFFF -> HKCCC -> HKDDD
> * Params顺序: PKAAA -> PKBBB -> PKEEE -> PKFFF -> PKCCC -> PKDDD
 
### 总结一句话就是,全局添加的在最开始,callback添加的在最后,请求添加的在中间
 
## 三、自定义CallBack使用

目前内部提供的包含`AbsCallback`, `StringCallBack` ,`BitmapCallback` ,`FileCallBack` ,可以根据自己的需求去自定义Callback

 * `AbsCallback`: 所有回调的父类，抽象类
 * `StringCallBack`：如果返回值类型是纯文本数据，即可使用该回调
 * `BitmapCallback`：如果请求的是图片数据，则可以使用该回调
 * `FileCallBack`：如果要做文件下载，则必须使用该回调，内部封装了关于文件下载进度回调的方法

###该网络框架的核心使用方法即为`Callback`的继承使用，详细请看 Demo 源码中`callback`包下的代码。
因为不同的项目需求，可能对数据格式进行了不同的封装，于是在 Demo 中的进行了详细的代码示例，以下是详细介绍：

 * `JsonCallback`：继承自`AbsCallback`,一般来说，服务器返回的响应码都包含 code，msg，data 三部分，在此根据自己的业务需要完成相应的逻辑判断，并对数据进行解析，可以使用 `Gson` 或者 `fastjson`，将解析的对象返回。
 * `DialogCallback`：继承自`JsonCallback`,对需要在网络请求的时候显示对话框，使用该回调。
 * `StringDialogCallback`：继承自`EncryptCallback`,如果网络返回的数据只是纯文本，使用该回调
 * `BitmapDialogCallback` ：继承自`BitmapCallback`,如果网络返回的是Bitmap对象，使用该回调
 * `DownloadFileCallBack` ：继承自`FileCallback`,如果需要做文件下载，使用该回调

以上基本是包含了大部分的业务逻辑，具体情况请参照demo示例，根据业务需求修改！

## 四、缓存的使用

###使用缓存前，必须让缓存的数据`javaBean`对象实现`Serializable`接口，否者会报`NotSerializableException`。
因为缓存的原理是将对象序列化后直接写入 数据库中，如果不实现`Serializable`接口，会导致对象无法序列化，进而无法写入到数据库中，也就达不到缓存的效果。

对于`DEFAULT`缓存模式,超时时间是无效的,因为该模式是完全遵循标准的http协议的,缓存时间是依靠服务端响应头来控制,所以客户端的cacheTime参数无效

目前提供了五种`CacheMode`缓存模式,每种缓存模式都可以指定对应的`CacheTime`,不同的模式会有不同的方法回调顺序,详细请看上面第二部分的callback执行顺序

 * `NO_CACHE`: 不使用缓存,该模式下,`cacheKey`,`cacheTime` 参数均无效
 * `DEFAULT`: 按照HTTP协议的默认缓存规则，例如有304响应头时缓存。
 * `REQUEST_FAILED_READ_CACHE`：先请求网络，如果请求网络失败，则读取缓存，如果读取缓存失败，本次请求失败。
 * `IF_NONE_CACHE_REQUEST`：如果缓存不存在才请求网络，否则使用缓存。
 * `FIRST_CACHE_THEN_REQUEST`：先使用缓存，不管是否存在，仍然请求网络。

###无论对于哪种缓存模式，都可以指定一个`cacheKey`，建议针对不同需要缓存的页面设置不同的`cacheKey`，如果相同，会导致数据覆盖。

## 五、混淆
```java
    #okhttputils
    -dontwarn com.lzy.okhttputils.**
    -keep class com.lzy.okhttputils.**{*;}
    
    #okhttpserver
    -dontwarn com.lzy.okhttpserver.**
    -keep class com.lzy.okhttpserver.**{*;}
    
    #okhttp
    -dontwarn okhttp3.**
    -keep class okhttp3.**{*;}
    
    #okio
    -dontwarn okio.**
    -keep class okio.**{*;}
```


