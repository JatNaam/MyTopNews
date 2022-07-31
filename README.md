# MyTopNews

框架是：TabLayout+ViewPager2实现页面滑动切换，Toolbar替代自带菜单栏
        tabLayout的内容是新闻的类型
        ViewPager2中嵌套的fragment已实现了复用，滑动是直接更新fragment的内容，而不是切换到另一个fragment
        fragment中的内容只有一个recycleView来显示新闻信息
        奇数项的新闻是通过隐式Intent响应网页打开
        偶数项的新闻是通过显式Intent响应跳转Activity使用WebView打开URL
        webView已经在后台帮我们处理好发送HTTP请求、接受服务器响应、解析返回数据和最终页面展示的工作
通过DrawerLayout+NavigationView来实现右滑显示个人信息