# NineGridImageView

[中文版说明点我](http://laobie.github.io/android/2016/03/06/nine-grid-iamge-view-libaray.html)

This is a custom widget for Android, which uesd for showing grid pictures, such as you seeing in weibo or wechat.

![](http://ac-qygvx1cc.clouddn.com/ee5906c846ad3346.png)

### Update Log

+ 1.0.3

    fix return data not original bug

+ 1.0.2

    + remove support library

+ 1.0.1 

	+ bug fix: if no image data or images size is zero, this view will not show;
	+ add set max size of images method;

+ 1.0.0 
	
	first publish

### Sample
[Download NineGridImageView-Demo](http://fir.im/bkxn)

### Features
+ set gap between images	

	`app:imgGap="4dp"` or `nineGridImageView.setGap(int gap);`
	
+ set max size of images（）	

	`app:maxSize="9"` or `nineGridImageView.setMaxSize(int maxSize);`
	
	if `maxSize` Less than or equal to 0, there may not limit for images size.

+ set style 

	`app:showStyle="fill"` or `nineGridImageView.setShowStyle(int style);`
	
	default style is `STYLE_GRID`:
	
	![](http://ac-qygvx1cc.clouddn.com/9cc94e97b4fce73f.png)
	
	another style is `STYLE_FILL`:
	
	![](http://ac-qygvx1cc.clouddn.com/0fa728fd90d1b227.png)
	
+ when only one image, you can set it's size by:

	`app:singleImgSize="120dp"` or `nineGridImageView.setSingleImgSize(int singleImgSize)`

### Usage
##### 1. Add the dependencies to your build.gradle file, NineGridImageView is avaiable in JCenter:

	compile 'com.jaeger.ninegridimageview:library:1.0.3'
	
##### 2. Add the NineGridImageView to your layout XML:

~~~ xml
<com.jaeger.ninegridimageview.NineGridImageView
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_height="wrap_content"
    android:layout_margin="16dp"
    android:layout_width="match_parent"
    app:imgGap="4dp"
    app:showStyle="fill"
    app:singleImgSize="120dp"/>
~~~	
        
##### 3. set a NineGridImageViewAdapter for NineGridImageView

	nineGridImageView.setAdapter(nineGridViewAdapter);
	
Here is `NineGridImageViewAdapter.class` source code:
	
~~~ java
public abstract class NineGridImageViewAdapter<T> {

    protected abstract void onDisplayImage(Context context, ImageView imageView, T t);

    protected void onItemImageClick(Context context, int index, List<T> list) {
    
    }

    protected ImageView generateImageView(Context context) {
        GridImageView imageView = new GridImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }
}			
~~~		   		

+ T is your image data model, you can simple use String or your own model
+ you must override `onDisplayImage(Context context, ImageView imageView, T t)` method to set load image way, you can use Picasso, Glide or ImageLoader etc, and you can also set place holder for `ImageView`.
+ if you need handle image click event, you can override `onItemImageClick(Context context, int index, List<T> list)` method, it is easy to handle image click event.
+ if you want to customize ImageView, you can override `generateImageView(Context context)` method, to generate your custom `ImageView`.
	
Here is sample code:
	
~~~ java	
private NineGridImageViewAdapter<Photo> mAdapter = new NineGridImageViewAdapter<Photo>() {
	@Override
	protected void onDisplayImage(Context context, ImageView imageView, Photo photo) {
		Picasso.with(context)
		    .load(photo.getSmallUrl)
		    .placeholder(R.drawable.ic_default_image)
		    .into(imageView);
    }

    @Override
    protected ImageView generateImageView(Context context) {
        return super.generateImageView(context);
    }

    @Override
    protected void onItemImageClick(Context context, int index, List<Photo> photoList) {
       showBigPicture(context, photoList.get(index).getBigUrl());
    }
};
        
...
	mNineGridImageView.setAdapter(mAdapter);
...
~~~

##### 4. set pictures data for NineGridImageView
~~~ java
nineGridImageView.setImagesData(List<T> imageDataList);
~~~
	
### Credits
- [panyiho/NineGridView](https://github.com/panyiho/NineGridView)
- [w4lle/NineGridView](https://github.com/w4lle/NineGridView)
	
### License

	Copyright 2016 Jaeger Chen

	Licensed under the Apache License, Version 2.0 (the "License");	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.

	
	
	 
		


