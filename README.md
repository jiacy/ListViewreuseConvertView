# Android 性能优化


## 【步骤一】ListView适配器ConvertView缓存及复用
### 【参考】https://blog.csdn.net/zhangphil/article/details/78435502


Android中的ListView常用Adapter中都会涉及convertView的使用；使用convertView是为了缓存视图View，用以增加ListView的item view的加载效率.
有经验的Android开发都知道在Adapter的getView()中，先判断convertView是否为空，如果非空，则直接对convertView复用，否则才创建新的view.

convertView发生作用的地方，就是当listview向上/向下滑动过程中，listview的头部item将滚出屏幕，而底部的新item将加载出来，此时convertview的复用机制将发挥作用。
由于此前在ListView初始化阶段已经创建了九个全新的convertView，Android系统将之前ListView初始化阶段创建的九个全新convertView都缓存起来，现在，由于ListView的上下翻动，顶部和底部之前显示的item滚出设备屏幕不可见，Android系统要么完全回收这些convertView，要么复用这些convertView。ListView的item有一个共同点：在大多数情况下，这些item的View是相同的，所以，明智的做法是继续复用，这样无疑会提高系统加载性能，要知道每一次创建新的convertView，是有一定系统开销的

## 【步骤二】基于ViewHolder技术提升Android ListView中的item view加载效率
### 【参考】https://blog.csdn.net/zhangphil/article/details/44779723
因为在findViewById的时候是一个IO操作，比较耗时，所以增加viewholder来提升性能
ViewHolder不是Android的开发API，而是一种设计方法，就是设计个静态类，缓存一下