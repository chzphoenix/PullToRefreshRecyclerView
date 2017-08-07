# WrapRecyclerView

This is a RecyclerView with some extra function, such as header/footer, OnItemClickListener, OnItemLongClickListener, etc.

The function of header and footer supports all types of LayoutManager, shown in the screenshots below
![](https://github.com/chzphoenix/PullToRefreshRecyclerView/blob/master/linear.png)
![](https://github.com/chzphoenix/PullToRefreshRecyclerView/blob/master/grid.png)
![](https://github.com/chzphoenix/PullToRefreshRecyclerView/blob/master/staggered.png)

Pls refer to the demo or read the source codes.


# PullToRefreshRecyclerView

This is a project based on RecyclerView with pull-to-refresh feature.

This project depend on com.loopeer.android.thirdparty:pulltorefresh:xxx. 

It also support adding Header and Footer because of WrapRecyclerView which is used in PullToRefreshRecyclerView.

![](https://github.com/chzphoenix/PullToRefreshRecyclerView/blob/master/demo.gif)


####WrapRecyclerView

WrapRecyclerView is extendsed on RecyclerView with adding Header and Footer just like ListView.

# Using library in your application
#####Gradle dependency:
``` groovy
compile 'com.hcz.fastwidget:pulltorefresh-recyclerview:1.0.4'
```
#####Maven dependency:
```xml
<dependency>
  <groupId>com.hcz.fastwidget</groupId>
  <artifactId>pulltorefresh-recyclerview</artifactId>
  <version>1.0.4</version>
  <type>pom</type>
</dependency>
```

