# for式


## 名称

~~~
for式
~~~

## 構文

```` scala
for ( ジェネレータ ; ジェネレータ繰返 ) 式
for ( ジェネレータ ; ジェネレータ繰返 ) yield 式
「ジェネレータ」とは 「 変数 <- コレクション if 条件式 ; 変数 = 式」
if 条件式 と 変数 = 式 は任意
````

## ソース

```` scala
// 例
for ( x <- 1 to 3 ; y <- 1 to 3 ; if x != y )
    println( "x=" + x + ",y=" + y )

// 例
var i = 0
do {
    println("i = " + i)
    i = i + 1
} while ( i <= 10)
````


## 実行結果
````scala
scala> var i = 0
i: Int = 0

scala> while(i <= 10) {
     |     println("i = " + i)
     |     i = i + 1
     | }
i = 0
i = 1
i = 2
i = 3
i = 4
i = 5
i = 6
i = 7
i = 8
i = 9
i = 10

--
// 例
scala> for ( x <- 1 to 3 ; y <- 1 to 3 ; if x != y )
     |     println( "x=" + x + ",y=" + y )
x=1,y=2
x=1,y=3
x=2,y=1
x=2,y=3
x=3,y=1
x=3,y=2

// 例
scala> do {
     |     println("i = " + i)
     |     i = i + 1
     | } while ( i <= 10)
i = 0
i = 1
i = 2
i = 3
i = 4
i = 5
i = 6
i = 7
i = 8
i = 9
i = 10

````
