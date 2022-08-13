package com.bytedance.movies.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.entities.Movie;
import com.bytedance.movies.R;
import com.bytedance.movies.fragment.adapter.MovieAdapter;

import java.io.Serializable;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MovieListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieListFragment extends Fragment {
    private View thisView;
    private ImageView titleScreenImageview;
    private RecyclerView recyclerView;
    private List<Movie> movieList;
    private Context context;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    public MovieListFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MovieListFragment newInstance(List<Movie> movieList) {
        MovieListFragment fragment = new MovieListFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, (Serializable) movieList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            movieList = (List<Movie>) getArguments().getSerializable(ARG_PARAM1);
            context = getContext();
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (thisView == null) {
            thisView = inflater.inflate(R.layout.fragment_movie, container, false);
            titleScreenImageview = (ImageView) thisView.findViewById(R.id.title_screen_imageview);
            recyclerView = thisView.findViewById(R.id.movie_recyclerview);
            initRecyclerView();
        }
        return thisView;
    }

    private void initRecyclerView() {
        GridLayoutManager manager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(manager);
        //test();

        MovieAdapter adapter = new MovieAdapter(movieList, getContext());
        recyclerView.setAdapter(adapter);
    }

    private void test() {

        String movieListJson = "{\"data\":{\"active_time\":\"2022-08-10\",\"description\":\"\",\"error_code\":0,\"list\":[{\"actors\":[\"沈腾\",\"马丽\",\"常远\",\"李诚儒\",\"黄才伦\",\"辣目洋子\",\"郝瀚\",\"黄子韬\",\"王成思\",\"高海宝\",\"杨铮\",\"史彭元\",\"张熙然\",\"黄若萌\",\"杨皓宇\"],\"directors\":[\"张吃鱼\"],\"discussion_hot\":3157174,\"hot\":12869717,\"id\":\"6903365126108381703\",\"influence_hot\":941747,\"maoyan_id\":\"1359034\",\"name\":\"独行月球\",\"name_en\":\"Moon Man\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/93204d13cf5a4fb080e74ea6d057eca1?from=552310259\",\"release_date\":\"2022-07-29\",\"search_hot\":1235954,\"topic_hot\":1121360,\"type\":1},{\"actors\":[\"古天乐\",\"刘青云\",\"刘嘉玲\",\"姜皓文\",\"谢君豪\",\"吴倩\",\"万国鹏\",\"张家辉\",\"刘浩良\",\"麦天枢\",\"朱鉴然\",\"程小夏\"],\"areas\":[\"香港\"],\"directors\":[\"吴炫辉\"],\"discussion_hot\":2812362,\"hot\":11565738,\"id\":\"6446787399010746893\",\"influence_hot\":843433,\"maoyan_id\":\"249033\",\"name\":\"明日战记\",\"name_en\":\"Warriors of Future\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/5d9299715de44f1db6645f3466d73173?from=552310259\",\"release_date\":\"2022-08-05\",\"search_hot\":1162772,\"tags\":[\"动作\",\"科幻\"],\"topic_hot\":1004299,\"type\":1},{\"actors\":[\"李汶翰\",\"徐若晗\",\"王博文\",\"高秋梓\",\"柯蓝\",\"苇青\"],\"directors\":[\"落落\"],\"discussion_hot\":2959386,\"hot\":11518789,\"id\":\"7073662696507474446\",\"influence_hot\":876239,\"maoyan_id\":\"1331205\",\"name\":\"遇见你\",\"name_en\":\"Almost Love\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/c2204b96045341ab9c2eaa6c33edeef6?from=552310259\",\"release_date\":\"2022-08-04\",\"search_hot\":1168759,\"topic_hot\":1009469,\"type\":1},{\"actors\":[\"马思纯\",\"王俊凯\",\"范伟\",\"曾美慧孜\",\"李晓川\",\"赵润南\",\"龚蓓苾\",\"黄璐\",\"莫西子诗\",\"曾慕梅\",\"万茜\",\"刘琳\"],\"areas\":[\"中国大陆\"],\"directors\":[\"李玉\"],\"discussion_hot\":2731443,\"hot\":10936015,\"id\":\"6894133081402245639\",\"influence_hot\":857093,\"maoyan_id\":\"1369917\",\"name\":\"断·桥\",\"name_en\":\"The Fallen Bridge\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/ad80a23419ea4e12bc8520378cd8e88a?from=552310259\",\"release_date\":\"2022-08-13\",\"search_hot\":1135381,\"tags\":[\"剧情\"],\"topic_hot\":884380,\"type\":1},{\"actors\":[\"杨凝\",\"李兰陵\",\"刘知否\",\"瞳音\",\"常文涛\",\"佟心竹\",\"山新\",\"李翰林\",\"图特哈蒙\",\"阎么么\",\"王琳熙\"],\"directors\":[\"王云飞\"],\"discussion_hot\":1700101,\"hot\":7603214,\"id\":\"7118672168472281631\",\"influence_hot\":790834,\"maoyan_id\":\"\",\"name\":\"疯了！桂宝之三星夺宝\",\"name_en\":\"CRAZY.KWAI.BOO Sanxingdui Spirited Away\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/078a28d12cae4e3daa3ab6092fe17c56?from=552310259\",\"release_date\":\"2022-07-29\",\"search_hot\":833742,\"topic_hot\":494465,\"type\":1},{\"actors\":[\"周依然\",\"吴念轩\",\"汤加文\",\"翁楚汉\",\"吴彦姝\",\"张歆艺\",\"袁弘\",\"谢治勋\",\"耿军\",\"詹妮\"],\"directors\":[\"吴家凯\",\"张智鸿\"],\"discussion_hot\":2235805,\"hot\":7532902,\"id\":\"7074839902659183111\",\"influence_hot\":784722,\"maoyan_id\":\"1331600\",\"name\":\"一直一直都很喜欢你\",\"name_en\":\"Love Can't Be Said\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/d1c81cff25824f84a921fd9300c5ca97?from=552310259\",\"release_date\":\"2022-07-22\",\"search_hot\":926189,\"topic_hot\":686487,\"type\":1},{\"actors\":[\"黄渤\",\"荣梓杉\",\"姚晨\",\"范伟\",\"贾冰\",\"许君聪\",\"于洋\",\"梅婷\",\"黄觉\",\"李泽宇\",\"范湉湉\"],\"directors\":[\"陈思诚\"],\"discussion_hot\":2507286,\"hot\":7281021,\"id\":\"6898272571448689159\",\"influence_hot\":853381,\"maoyan_id\":\"1357145\",\"name\":\"外太空的莫扎特\",\"name_en\":\"Mozart from Space\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/2333bc223d5a4cc591093f4e893bbf6f?from=552310259\",\"release_date\":\"2022-07-15\",\"search_hot\":948200,\"topic_hot\":799342,\"type\":1},{\"actors\":[\"李孝谦\",\"漆昱辰\",\"林俊毅\",\"修雨秀\",\"许童心\",\"丁冠森\",\"李光洁\",\"周深\",\"沈月\",\"张奕聪\",\"高至霆\",\"孙浩\",\"姜卓君\",\"张熙然\",\"夏子轩\"],\"directors\":[\"王梓骏\"],\"discussion_hot\":1856390,\"hot\":7063664,\"id\":\"7077392575660818980\",\"influence_hot\":0,\"maoyan_id\":\"1310222\",\"name\":\"我们的样子像极了爱情\",\"name_en\":\"Close to Love\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/ec798d50b0bd4053a8436b26d31f0aaa?from=552310259\",\"release_date\":\"2022-08-04\",\"search_hot\":0,\"topic_hot\":669214,\"type\":1},{\"actors\":[\"陆双\",\"谢蔚\",\"吉莹\",\"吴海涛\",\"白文显\",\"陈志荣\"],\"directors\":[\"陆锦辉\",\"钟彧\"],\"discussion_hot\":1624450,\"hot\":7018416,\"id\":\"7069703033898140168\",\"influence_hot\":486369,\"maoyan_id\":\"1358119\",\"name\":\"猪猪侠大电影·海洋日记\",\"name_en\":\"GG BOND：Ocean Mission\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/dcef320b1d774b07908a90b7b26a4fdd?from=552310259\",\"release_date\":\"\",\"search_hot\":739400,\"topic_hot\":420232,\"type\":1},{\"actors\":[\"刘红韵\",\"邓玉婷\",\"严彦子\",\"祖晴\",\"高全胜\",\"苗浩生\",\"李团\",\"申克\",\"胡严彦\",\"李薇薇\"],\"areas\":[\"中国大陆\"],\"directors\":[\"黄伟明\"],\"discussion_hot\":2191873,\"hot\":6977739,\"id\":\"6803949067538792968\",\"influence_hot\":949076,\"maoyan_id\":\"1297952\",\"name\":\"开心超人之英雄的心\",\"name_en\":\"The Stones\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/2c9639d6d5a74b8baa9c888096ffbd43?from=552310259\",\"release_date\":\"2022-07-22\",\"search_hot\":873542,\"tags\":[\"动画\"],\"topic_hot\":579086,\"type\":1},{\"actors\":[\"王千源\",\"郭晓东\",\"王迅\",\"许龄月\",\"马渝捷\",\"倪大红\",\"关晓彤\",\"张兆辉\",\"张光北\",\"童蕾\",\"郭晓峰\",\"杨洛仟\"],\"areas\":[\"中国大陆\"],\"directors\":[\"郭晓峰\"],\"discussion_hot\":2501313,\"hot\":6973434,\"id\":\"6858859543187849741\",\"influence_hot\":0,\"maoyan_id\":\"1302480\",\"name\":\"猎屠\",\"name_en\":\"Butcher Hunter\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/a5de28bf4370a36f5e8261f007faee35?from=552310259\",\"release_date\":\"2022-06-03\",\"search_hot\":0,\"topic_hot\":786927,\"type\":1},{\"actors\":[\"张译\"],\"areas\":[\"中国大陆\"],\"directors\":[\"黄健明\"],\"discussion_hot\":2319255,\"hot\":6898295,\"id\":\"6531973976749507076\",\"influence_hot\":0,\"maoyan_id\":\"346331\",\"name\":\"再见怪兽\",\"name_en\":\"\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/8dc89481d0a2332fd56f4c28a5d05c56?from=552310259\",\"release_date\":\"\",\"search_hot\":0,\"tags\":[\"动画\"],\"topic_hot\":751677,\"type\":1},{\"actors\":[\"刘青云\",\"蔡卓妍\",\"林峯\",\"谭凯\",\"陈家乐\",\"汤怡\",\"何珮瑜\",\"李若彤\",\"吴浩康\",\"洪天明\",\"车婉婉\",\"斌子\",\"李菁\",\"马志威\",\"杨天宇\",\"胡子彤\",\"朱鉴然\",\"马睿瀚\"],\"areas\":[\"香港\"],\"directors\":[\"韦家辉\"],\"discussion_hot\":2519109,\"hot\":6809290,\"id\":\"6531972731066384900\",\"influence_hot\":912908,\"maoyan_id\":\"1203439\",\"name\":\"神探大战\",\"name_en\":\"Cold Detective\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/73a0215e0c2d41efb338aa248e6d2978?from=552310259\",\"release_date\":\"2022-07-08\",\"search_hot\":1005198,\"tags\":[\"动作\",\"悬疑\",\"犯罪\"],\"topic_hot\":855084,\"type\":1},{\"discussion_hot\":1888680,\"hot\":6200050,\"id\":\"7069703142962627080\",\"influence_hot\":0,\"maoyan_id\":\"1439146\",\"name\":\"迷你世界之觉醒\",\"name_en\":\"KAKA\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/d0b5a94a41aa4f8088a63577d1ffbb8e?from=552310259\",\"release_date\":\"\",\"search_hot\":0,\"topic_hot\":219600,\"type\":1},{\"actors\":[\"周迅\",\"郑秀文\",\"易烊千玺\",\"许娣\",\"冯德伦\",\"黄米依\",\"鲍起静\",\"白客\",\"苏小明\",\"巴图\",\"朱雅芬\",\"方平\",\"马昕墨\"],\"areas\":[\"中国大陆\"],\"directors\":[\"张艾嘉\",\"李少红\",\"陈冲\"],\"discussion_hot\":2204888,\"hot\":6070753,\"id\":\"6920024822365815309\",\"influence_hot\":690007,\"maoyan_id\":\"1359285\",\"name\":\"世间有她\",\"name_en\":\"HerStory\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/bb9e052600d647b485289db9be540cfd?from=552310259\",\"release_date\":\"2022-09-09\",\"search_hot\":868346,\"topic_hot\":774641,\"type\":1},{\"actors\":[\"锦鲤\",\"李岱昆\",\"张磊\",\"阎萌萌\",\"杨凝\",\"晨宁溪\",\"张遥函\",\"齐斯伽\",\"高枫\",\"赵明洲\",\"敖磊\",\"郭政建\"],\"areas\":[\"中国大陆\"],\"directors\":[\"胡一泊\"],\"discussion_hot\":2025286,\"hot\":6014446,\"id\":\"6531988673146126851\",\"influence_hot\":848814,\"maoyan_id\":\"1212472\",\"name\":\"冲出地球\",\"name_en\":\"Rainbow Sea Fly High\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/dcfe0db1f97b47ecb801e1858dd93798?from=552310259\",\"release_date\":\"2022-07-16\",\"search_hot\":899560,\"tags\":[\"科幻\",\"动画\",\"冒险\"],\"topic_hot\":615509,\"type\":1},{\"actors\":[\"倪妮\",\"张鲁一\",\"辛柏青\",\"池松壮亮\",\"中野良子\",\"新音\",\"王佳佳\",\"耐安\",\"毛乐\"],\"directors\":[\"张律\"],\"discussion_hot\":2015303,\"hot\":5801604,\"id\":\"7118672661575959076\",\"influence_hot\":0,\"maoyan_id\":\"\",\"name\":\"漫长的告白\",\"name_en\":\"Yanagawa\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/15f516da827b4233a5a9b25be3fa09b9?from=552310259\",\"release_date\":\"2022-08-04\",\"search_hot\":0,\"topic_hot\":437761,\"type\":1},{\"actors\":[\"武仁林\",\"海清\",\"杨光锐\",\"武赟志\",\"李生甫\",\"张敏\",\"赵登平\",\"王彩兰\",\"曾建贵\",\"马占红\",\"王翠兰\",\"续彩霞\"],\"directors\":[\"李睿珺\"],\"discussion_hot\":2073724,\"hot\":5393304,\"id\":\"7065249891530113543\",\"influence_hot\":715073,\"maoyan_id\":\"1336601\",\"name\":\"隐入尘烟\",\"name_en\":\"Return to Dust\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/89b1dda86dfd43ecac9e2e1c22f1a9dd?from=552310259\",\"release_date\":\"2022-07-08\",\"search_hot\":872094,\"tags\":[\"剧情\",\"爱情\"],\"topic_hot\":537781,\"type\":1},{\"actors\":[\"普加·巴哈卢卡\",\"Parth Suri\",\"石天龙\",\"母其弥雅\",\"何椰子\",\"Abhimanyu Sharma\",\"拉兹巴·亚达夫\",\"Ravi Kale\",\"Prateek Parma\"],\"directors\":[\"拉姆·戈帕尔·维马\",\"刘静\"],\"discussion_hot\":1602847,\"hot\":5067906,\"id\":\"7034344828066333215\",\"influence_hot\":660455,\"maoyan_id\":\"1437427\",\"name\":\"龙女孩\",\"name_en\":\"Enter the Girl Dragon\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/22886838135e473183c4a37a33a8105f?from=552310259\",\"release_date\":\"2022-07-15\",\"search_hot\":680783,\"topic_hot\":326919,\"type\":1},{\"actors\":[\"朱一龙\",\"杨恩又\",\"王戈\",\"刘陆\",\"罗京民\",\"吴倩\",\"郑卫莉\",\"陈创\",\"李春嫒\",\"钟宇升\",\"刘亚津\",\"刘浩\",\"韩延\"],\"directors\":[\"刘江江\"],\"discussion_hot\":2509475,\"hot\":5025085,\"id\":\"6966889198838252045\",\"influence_hot\":975100,\"maoyan_id\":\"1397016\",\"name\":\"人生大事\",\"name_en\":\"Lighting Up the Stars\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/e58231caf9eb4e88ab5e5575e493b667?from=552310259\",\"release_date\":\"2022-06-24\",\"search_hot\":1039551,\"topic_hot\":897537,\"type\":1},{\"discussion_hot\":1372070,\"hot\":4949378,\"id\":\"7108554671324660237\",\"influence_hot\":0,\"maoyan_id\":\"\",\"name\":\"迷失之城 The Lost City\",\"name_en\":\"The Lost City\",\"poster\":\"\",\"release_date\":\"\",\"search_hot\":0,\"topic_hot\":310922,\"type\":1},{\"actors\":[\"泰莉莎·加拉赫\",\"西蒙·格林诺\",\"迈克尔·墨菲\",\"保罗·潘廷\",\"韦恩·格雷森\",\"罗布·拉克斯特拉夫\",\"Helen Walsh\",\"基思·威克姆\",\"安德烈斯·威廉姆斯\",\"乔·怀亚特\",\"珍妮·约科波里\"],\"areas\":[\"英国\"],\"directors\":[\"布莱尔·西蒙斯\"],\"discussion_hot\":1542807,\"hot\":4793878,\"id\":\"7094203739543863816\",\"influence_hot\":643804,\"maoyan_id\":\"\",\"name\":\"海底小纵队：洞穴大冒险\",\"name_en\":\"Octonauts and the Caves of Sac Actun\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/04476718610b4bfa9db229ee86064a7d?from=552310259\",\"release_date\":\"2020-07-09\",\"search_hot\":745883,\"tags\":[\"喜剧\",\"动画\",\"冒险\"],\"topic_hot\":430886,\"type\":1},{\"actors\":[\"马赛\",\"任达华\",\"吴镇宇\",\"洪天明\",\"余香凝\",\"吴澋滔\",\"元华\",\"林恺铃\",\"伍咏诗\",\"胡子彤\",\"徐浩昌\",\"龚慈恩\",\"张达明\",\"张锦程\",\"林雪\",\"刘国昌\"],\"areas\":[\"香港\",\"中国大陆\",\"中国香港\"],\"directors\":[\"杜琪峰\",\"徐克\",\"许鞍华\",\"林岭东\",\"谭家明\",\"洪金宝\",\"袁和平\"],\"discussion_hot\":1323792,\"hot\":4703626,\"id\":\"6446319343134310926\",\"influence_hot\":0,\"maoyan_id\":\"248182\",\"name\":\"七人乐队\",\"name_en\":\"Eight And A Half\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/b1437fe277312c5e18bdf69fe74f2f17?from=552310259\",\"release_date\":\"2022-07-29\",\"search_hot\":0,\"tags\":[\"剧情\",\"历史\"],\"topic_hot\":202605,\"type\":1},{\"actors\":[\"许烈英\",\"王思蓉\",\"刘子涵\"],\"directors\":[\"陶涛\",\"张琪\",\"秦博\",\"范士广\"],\"discussion_hot\":2460249,\"hot\":4576113,\"id\":\"7039325286676038174\",\"influence_hot\":743673,\"maoyan_id\":\"1429716\",\"name\":\"人间世\",\"name_en\":\"Once Upon a Life\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/7930e8b762a44382bc96621a06398952?from=552310259\",\"release_date\":\"\",\"search_hot\":0,\"topic_hot\":166744,\"type\":1},{\"actors\":[\"吴京\",\"易烊千玺\",\"段奕宏\",\"张涵予\",\"朱亚文\",\"李晨\",\"韩东君\",\"耿乐\",\"杜淳\",\"胡军\"],\"directors\":[\"陈凯歌\",\"徐克\",\"林超贤\"],\"discussion_hot\":1367189,\"hot\":3961375,\"id\":\"7024141505304625700\",\"influence_hot\":1025825,\"maoyan_id\":\"1446115\",\"name\":\"长津湖之水门桥\",\"name_en\":\"The Battle at Lake Changjin II\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/800a70903eeb44fa9548237ae201d3fb?from=552310259\",\"release_date\":\"2022-02-01\",\"search_hot\":899915,\"tags\":[\"剧情\",\"历史\",\"战争\"],\"topic_hot\":708428,\"type\":1},{\"actors\":[\"易烊千玺\",\"田雨\",\"陈哈琳\",\"齐溪\",\"公磊\",\"许君聪\",\"王宁\",\"黄尧\",\"巩金国\",\"田壮壮\",\"王传君\",\"徐峥\",\"章宇\",\"张志坚\",\"咏梅\",\"杨新鸣\",\"朱俊麟\",\"贾弘逍\",\"陈翊曈\",\"陈哈琳\",\"岳小军\",\"朱俊麟\",\"王丽涵\",\"贾弘逍\",\"韩笑\",\"孙征宇\",\"黄艺馨\",\"修梦迪\",\"苏子航\",\"郑伊倩\",\"丁文博\",\"王一博\",\"白宇\",\"王圣迪\"],\"areas\":[\"中国大陆\"],\"directors\":[\"文牧野\"],\"discussion_hot\":1213293,\"hot\":3710635,\"id\":\"6947574949951308318\",\"influence_hot\":931548,\"maoyan_id\":\"1383307\",\"name\":\"奇迹·笨小孩\",\"name_en\":\"Nice View\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/a25a554fba8742938b14f430c1428929?from=552310259\",\"release_date\":\"2022-02-01\",\"search_hot\":861299,\"tags\":[\"剧情\"],\"topic_hot\":631003,\"type\":1},{\"actors\":[\"陈永胜\",\"章宇\",\"曹操\",\"柯国庆\",\"刘奕铁\",\"黄炎\",\"赵琥成\",\"王梓屹\",\"陈铭杨\",\"王乃训\",\"李汶聪\",\"程泓鑫\",\"张译\",\"林博洋\",\"钱焜\",\"AJ Donnelly\",\"柯南·何裴\",\"凯文·李\",\"勃小龙\"],\"directors\":[\"张艺谋\",\"张末\"],\"discussion_hot\":1119527,\"hot\":3680646,\"id\":\"6951008600240325157\",\"influence_hot\":870168,\"maoyan_id\":\"1367251\",\"name\":\"狙击手\",\"name_en\":\"Snipers\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/04a7512d8f104c01ace497b2c8ba3289?from=552310259\",\"release_date\":\"2022-02-01\",\"search_hot\":1007991,\"tags\":[\"剧情\",\"战争\",\"历史\"],\"topic_hot\":494564,\"type\":1},{\"actors\":[\"张译\",\"吴京\",\"李九霄\",\"魏晨\",\"Vladimir Ershov\",\"邱天\",\"周思羽\",\"邓超\",\"欧豪\",\"张承\",\"刘显达\",\"杨轶\",\"齐超\",\"朱梓瑜\",\"刘雨辰\",\"万沛鑫\",\"石昊正\"],\"directors\":[\"管虎\",\"郭帆\",\"路阳\"],\"discussion_hot\":1597593,\"hot\":3419615,\"id\":\"6882965933837517326\",\"influence_hot\":781871,\"maoyan_id\":\"1339160\",\"name\":\"金刚川\",\"name_en\":\"The Sacrifice\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/4c973ee2521487e9e9895cdb87b8824c?from=552310259\",\"release_date\":\"2020-10-23\",\"search_hot\":866611,\"tags\":[\"剧情\",\"战争\"],\"topic_hot\":666144,\"type\":1},{\"actors\":[\"吴京\",\"易烊千玺\",\"段奕宏\",\"张涵予\",\"朱亚文\",\"李晨\",\"韩东君\",\"胡军\",\"黄轩\",\"欧豪\",\"史彭元\",\"李岷城\",\"唐国强\",\"杨一威\",\"周小斌\",\"林永健\",\"王宁\",\"刘劲\",\"卢奇\",\"王伍福\",\"耿乐\",\"曹阳\",\"李军\",\"王同辉\",\"艾米\",\"石昊正\",\"许明虎\",\"卢奇\",\"曹阳\",\"李军\",\"郑恺\",\"张国立\"],\"areas\":[\"中国大陆\"],\"directors\":[\"陈凯歌\",\"徐克\",\"林超贤\",\"冯小刚\"],\"discussion_hot\":1545883,\"hot\":3278055,\"id\":\"6455308856976212493\",\"influence_hot\":1025825,\"maoyan_id\":\"257706\",\"name\":\"长津湖\",\"name_en\":\"The Battle at Lake Changjin\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/44e3a92362504154980c603a776c2e6e?from=552310259\",\"release_date\":\"2021-09-30\",\"search_hot\":1026890,\"tags\":[\"剧情\",\"历史\",\"战争\"],\"topic_hot\":847369,\"type\":1},{\"actors\":[\"赵今麦\",\"林一\",\"沈月\",\"汪佳辉\",\"范诗然\",\"张宸逍\"],\"directors\":[\"林孝谦\"],\"discussion_hot\":2179866,\"hot\":3144447,\"id\":\"7069696726600253988\",\"influence_hot\":932482,\"maoyan_id\":\"1336701\",\"name\":\"一周的朋友\",\"name_en\":\"One Week Friends\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/0fce6195ee5d45729dda4da915ea1812?from=552310259\",\"release_date\":\"2022-06-18\",\"search_hot\":943958,\"topic_hot\":648476,\"type\":1}]},\"extra\":{\"logid\":\"2022081100380701021206804823222026\",\"now\":1660149487740}}\n";
        JSONObject bean = JSONObject.parseObject(movieListJson);
        JSONObject data = bean.getJSONObject("data");
        movieList = JSONArray.parseArray(data.getString("list"),Movie.class);

    }
}
