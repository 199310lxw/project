package com.example.componentdemo;

import android.app.Application;

/*************************************
 * @Author : liuxiangwang
 * @Date : 16:24  2020/9/1
 * @Email : liuxiangwang@vivo.com
 * @title : 
 * @Company : www.vivo.com
 * @Description : 
 ************************************/
class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }
//    private void  initComponent() {
//        // 初始化
//        Component.init(
//                BuildConfig.DEBUG,
//                Config.with(this)
//                        .defaultScheme("router")
//                        // 使用内置的路由重复检查的拦截器, 如果为 true,
//                        // 那么当两个相同的路由发生在指定的时间内后一个路由就会被拦截
//                        .useRouteRepeatCheckInterceptor(true)
//                        // 1000 是默认的, 表示相同路由拦截的时间间隔
//                        .routeRepeatCheckDuration(1000)
//                        // 是否打印日志提醒你哪些路由使用了 Application 为 Context 进行跳转
//                        .tipWhenUseApplication(true)
//                        .build()
//        );
//        // 如果你依赖了 rx 版本,需要配置这句代码,否则删除这句
//        RxErrorIgnoreUtil. ignoreError();
//      // 注册其他业务模块,注册的字符串是上面各个业务模块配置在 build.gradle 中的 HOST
//        ModuleManager.getInstance().registerArr("component1","component2","user","help");
//      // 让框架在 Debug 的时候检查.
//        if (BuildConfig.DEBUG) {
//            // 框架还带有检查重复的路由和重复的拦截器等功能,在 `debug` 的时候开启它
//            ModuleManager.getInstance().check();
//        }
//    }
}
