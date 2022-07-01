# 概要
SpringBootの単体テストの動きを確認するためのリポジトリです。個人用の忘備録です。<br>
プロダクトコードとテストコードを書いております。<br>


# 背景
私が現在制作しているポートフォリオにおいてテストコードの実装力に難がありましたので作成しました。<br>
いきなりポートフォーリオにテストコードを実装するとハードルが高くなるので、プロダクトコードを単純にしています。<br>


# 目標<br>
**現在私が作成しているポートフォーリオの技術的負債を解消**と**単体テストの実装**が目標です。<br>
技術的負債はプロダクトコード依存によるものだと私は考えます。<br>
プロダクトコードのソフトウェアアーキテクチャーを考慮していない（形だけ）ため技術負債になっていると私は考えます。<br>
結果プロダクトコードの保守性、可読性、検証しやすさが低下して、テストコードが書きにくくなるという形で現れたのかなと私は考えます。<br>
テストコードの実装力も足りないのも問題なのですが、プロダクトコードのほう課題としてレベルが高いと私は考えます。<br>

具体的な改善方法としては、<br>
#### プロダクトコード
1.ソフトウェアアーキテクチャーを考える。**MVCとService Repository**の構造で実装します。特にContrllerの責務をServiceに移して単体テストしやすい状況を作る。<br>
2.クラス、メソッドの責務を明確にする。<br>
#### テストコード
1.単体テストを書く(書く癖を身につける) <br>
2.テストフレームワークのセオリーを身につける。JUNIT5、Mockito、MockMvcの習熟度を上げるのは必須<br>


# 動作環境
OS：Windows10<br>
IDE:IntelliJ Community <br>
Java:17(11でも確認済み) <br>
Springboot:2.7.0 <br>
JUnit5 <br>
Mockito:Springbootのバージョンに依存<br>
MockMvc:Springbootのバージョンに依存<br>


# 項目
項目はブランチ別で分けています。

### thymeleaf
進捗：完了<br>
thymeleafで難しかった点をまとめています。(これに関してはテストコード書いてないです。)<br>
branch名:thymeleaf <br>
Qiita:https://qiita.com/RYA234/items/0fdf56f0e1813e6cf68f


### validation
進捗：完了<br>
branch名：Validation<br>
Qiita: https://qiita.com/RYA234/items/b1eec2aa43368aec928d

### csvファイル出力
進捗：途中<br>
branch名：csv_out<br>
Qiita：作成途中

### SpringSecurity
進捗：途中<br>
branch名：Security<br>