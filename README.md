# Android3DWheelView
我主要修改了支持了1、wrap_content高度自动计算处理。2、另外支持list的item设值。3、同时支持自定义属性在xml自动提示的处理

1、对于需要设置List<T extends Object>的list给滚轮的话，需要对T实现OnTextDislpayListener接口，其中的getDisplayInItem()方法就是返回在item中显示的text。

2、对于已经选择的item，可以通过getSelectItem(）来获取已经选中的对象。

3、支持warp_content，对于不确定高度的，只需要设置awv_itemsVisibleCount属性，会根据控件个数自动调整滚轮的高度。

展示的效果图：
![](https://raw.githubusercontent.com/WelliJohn/Android3DWheelView/master/screenshots/Screenshot_20170521-230807.png)控件由此处改造 鸣谢：https://github.com/weidongjian/androidWheelView
