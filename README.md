# JetpackMovie

### 使用Jetpack新的Library和TMDB的Api電影資料，製作的介紹電影APP。

##### Library
1. DB:Room
2. DI:Koin
3. Network:retrofit+coroutine+gson
4. UI:ViewBinding，Navigation，Epoxy，Lottie，SmartRefresh

##### 架構 : MVVM
##### 主題 : Light，Dark

## [Demo APK](https://github.com/CiaShangLin/JetpackMovie/blob/master/JetpackMovie.apk?raw=true "Demo APK")

## [Google Play](https://play.google.com/store/apps/details?id=com.shang.jetpackmovie "Google Play")

## [Youtube Demo](https://youtu.be/eQPdxdwL8EQ "Youtube Demo")

## Release note
### v2.0
1.升級compileSdk 33，targetSdk 33
2.升級Kotlin 1.6.0
3.升級Koin 3.2.2因為Kotlin升級的原因
4.新增Firebase
5.由於Kotlin升級導致Epoxy在綁定data時會拿取data class的hashCode，可能是資料有某個欄位是null導致拿取hashCode丟出NEP，所以data class的欄位都預設nullable。

## 心得
- Koin<br>
  第一次使用DI確實是相當方便，簡化了許多注入的程式碼，尤其是Koin支援ViewModel，終於不用寫又臭又長的Factory真的爽，只是像有一些Adapter需要傳入Listener而Listener實作在ViewModel，如果使用Koin去產生Adapter這個時候會產生不同的ViewModel，可能Adapter只能使用傳入的方法。<br>
  另外如果某個class要傳入某個介面，而這個介面如果有許多人實作那Koin到底怎麼區分？可惜專案沒遇到這個問題。<br>
  最後DI的模式其實是強制我們要傳入而不是在裡面直接宣告，這樣有助於抽換和測試，只不過這個學習曲線相對比較陡峭比較痛苦。<br>

- Coroutine<br>
  Kotlin專用的異步函數庫，retrofit也有特別支援suspend可以直接使用，但是說什麼輕量化比Rx簡單聽他在放屁，輕量化估計只是體積比較小，比較簡單的部分大概是線程切換，實質上學習曲線跟Rx估計差不了多少。<br>
  使用Coroutine的原因是Kotlin原生支援加上有其他Library也有支援像是coil(圖片函式庫)，所以還是加減要學。目前遇到困難的點是他提供的函數使用起來不像Rx這麼方便，例如:zip,mergeDelayError...，還有就是因為是原生的所以Android其實是另外支援的，這就會導致在google搜尋的時候很常找不到Android的情境，再搭配Android的flow,stateLiveData,launch,await,async...這一堆有的沒的關鍵字真的是需要大量的經驗才能懂。<br>

- Epoxy<br>
  airbnb推出的RecyclerView的Library，目前7.8K星星之前還有在104看過希望有Epoxy的經驗，就讓我很好奇這個Library是有多好用，Epoxy主要就三個東西Controller，EpoxyModel，EpoxyHolder。<br>
  Controller就想成是Adapter決定要顯示哪些ViewHolder，顯示的順序，資料的暫存。<br>
  EpoxyModel透過@annotate來綁定LayoutID和綁定viewHolder要顯示的資料。<br>
  EpoxyHolder基本上就是宣告元件的ID用的，通常不會有邏輯在裡面。<br>
  另外還有提供很多的@annotate來綁定data或是listenter之類的，還有水平嵌套，整體來說真的是滿好用滿簡潔的。<br>
  不過也有一些坑例如:我寫了一個BaseModel來提供給子類繼承，在子類要useLayoutOverloads = true打開然後覆寫getViewType()，不然在切換的時候會丟出ClassCastException，原因應該是裡面的緩存透過viewType來判斷是哪個Model，如果都沒設置的情況下會用到默認值。<br>
  還有就是水平嵌套RecyclerView(CarouselModel)，這個Model是Epoxy提供的不需要額外寫，遇到的問題是他會幫你預設一個LinearSnapHelper這樣會導致有一些不能滑到底或是滑不回第一個，也有設置的方法setDefaultGlobalSnapHelperFactory但是他是靜態全域的，這樣就會導致有些想要snap有些不想要辦不到，所以只能自己繼承出來一個沒有snap的[CarouselModel](https://github.com/CiaShangLin/JetpackMovie/blob/master/app/src/main/java/com/shang/jetpackmovie/epoxy/NoSnapCarousel.kt "CarouselModel")。<br>

- ViewBinding<br>
  有了ViewBinding之後就不用findViewById了，可以搭配這個[Util](https://github.com/CiaShangLin/JetpackMovie/blob/master/app/src/main/java/com/shang/jetpackmovie/ui/ViewBindingProperty.kt "Util")可以減少很多樣板程式碼，雖然有DataBinding可以用但是感覺還是很複雜所以還是比較喜歡單純的ViewBinding。<br>

- Navigation<br>
  Jetpack推出來管理Fragment切換用的Library，比較可惜的是目前這個小專案沒什麼用到，只有跟BottomNavigation配合使用，但是他在切換時好像都是用replace而且同樣的頁面在點擊他還是會再做一次，之後如果仔細操作可能要注意，還有在Fragment裡面使用的話會如何，可能要等到之後加入比較複雜的新功能才有機會了。<br>

- Theme<br>
  第一次實作可以切換主題的APP，不得不說滿麻煩的，各個區塊要用什麼顏色，文字要用什麼顏色真的麻煩，style和attr寫了一堆，可能真的要學預設的colorPrimary...之類的下去定義顏色，但是官網的教學也是有看沒有懂加上工程師基本上的顏色沒什麼感覺ㄏ，還有就是如果設置的背景是出圖的那就要每個主題都出一張可能會導致apk膨脹，所以主題這東西如果要做最好一開始就做中途才要加絕對累死。<br>

