# MyTopNews

# 1 框架
    TabLayout+ViewPager2实现页面滑动切换，Toolbar替代自带菜单栏
# 2 通过DrawerLayout+NavigationView来实现右滑显示个人信息
# 3 TabLayout的内容是新闻的类型
# 4 ViewPager2中嵌套的fragment实现复用
    4.1 滑动是直接更新fragment的内容，而不是切换到另一个fragment
    4.2 fragment中的内容只有一个recycleView来显示新闻信息
            奇数项的新闻是通过隐式Intent响应网页打开
            偶数项的新闻是通过显式Intent响应跳转Activity使用WebView打开URL
    4.3 WebView已经封装好发送HTTP请求、接受服务器响应、解析返回数据和最终页面展示的功能
