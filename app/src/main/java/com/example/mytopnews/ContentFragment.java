package com.example.mytopnews;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytopnews.newslist.News;
import com.example.mytopnews.newslist.NewsAdapter;
import com.example.mytopnews.newstypelist.NewsType;
import com.example.mytopnews.newstypelist.NewsTypeAdapter;

import java.util.ArrayList;
import java.util.List;

public class ContentFragment extends Fragment {
    private final List<NewsType> newsTypeList = new ArrayList<>();
    private final List<News> newsList = new ArrayList<>();
    private NewsTypeAdapter newsTypeAdapter;
    private NewsAdapter newsAdapter;
    private int flag = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_frag, container, false);
        initNewsType();
        RecyclerView newsTypeRecyclerView =view.findViewById(R.id.recyclerViewForNewsType);
        LinearLayoutManager layoutManagerType = new LinearLayoutManager(getActivity());
        layoutManagerType.setOrientation(LinearLayoutManager.HORIZONTAL); //将布局设为横向排列
        newsTypeRecyclerView.setLayoutManager(layoutManagerType);
        newsTypeAdapter =new NewsTypeAdapter(this,newsTypeList);
        newsTypeRecyclerView.setAdapter(newsTypeAdapter);

        initNewsB();
        RecyclerView newsListRecyclerView = view.findViewById(R.id.recyclerViewForNewsList);
        LinearLayoutManager layoutManagerNews = new LinearLayoutManager(getActivity());
        newsListRecyclerView.setLayoutManager(layoutManagerNews);
        newsAdapter = new NewsAdapter(newsList);
        newsListRecyclerView.setAdapter(newsAdapter);

        return view;
    }

    private void initNewsType() {
        NewsType business = new NewsType("Business", R.drawable.tab_business);
        newsTypeList.add(business);
        NewsType entertainment = new NewsType("Entertainment", R.drawable.tab_entertainment);
        newsTypeList.add(entertainment);
        NewsType health = new NewsType("Health", R.drawable.tab_health);
        newsTypeList.add(health);
        NewsType science = new NewsType("Science", R.drawable.tab_science);
        newsTypeList.add(science);
        NewsType sport = new NewsType("Sport", R.drawable.tab_sport);
        newsTypeList.add(sport);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void refresh(int flag) {
        if (this.flag == flag)
            return;
        else this.flag = flag;
        if (flag == 0)
            initNewsB();
        else if (flag == 1)
            initNewsE();
        else if (flag == 2)
            initNewsH();
        else if (flag == 3)
            initNewsSC();
        else if (flag == 4)
            initNewsSP();
        newsAdapter.notifyDataSetChanged();//通知数据发生变化
    }

    private void initNewsB() {
        newsList.clear();
        News news1 = new News(R.drawable.pic_business1,
                "四川仁寿：水稻秧苗管护忙",
                "cnsphoto.com",
                "2022-04-11 19:27:53",
                "http://www.cnsphoto.com/newDetail/single/12036076?pictureId=31148810");
        newsList.add(news1);
        News news2 = new News(R.drawable.pic_business2,
                "今年首季山东签发RCEP原产证2.4万份 数量居中国首位",
                "cnsphoto.com",
                "2022-04-11 18:59:21",
                "http://www.cnsphoto.com/newDetail/single/12036152?pictureId=31149292");
        newsList.add(news2);
        News news3 = new News(R.drawable.pic_business3,
                "河北涿州：梨花飘香春管忙",
                "cnsphoto.com",
                "2022-04-11 18:55:53",
                "http://www.cnsphoto.com/newDetail/single/12036038?pictureId=31148118");
        newsList.add(news3);
        News news4 = new News(R.drawable.pic_business4,
                "3月份中国CPI同比涨1.5% 鲜菜价格上涨17.2%",
                "cnsphoto.com",
                "2022-04-11 18:54:36",
                "http://www.cnsphoto.com/newDetail/single/12036138?pictureId=31149240");
        newsList.add(news4);
        News news5 = new News(R.drawable.pic_business5,
                "香港恒生指数大跌663点",
                "cnsphoto.com",
                "2022-04-11 17:47:52",
                "http://www.cnsphoto.com/newDetail/single/12036014?pictureId=31148072");
        newsList.add(news5);
        News news6 = new News(R.drawable.pic_business6,
                "安徽芜湖：服装企业生产忙",
                "cnsphoto.com",
                "2022-04-11 17:44:23",
                "http://www.cnsphoto.com/newDetail/single/12035932?pictureId=31147532");
        newsList.add(news6);
    }

    private void initNewsE() {
        newsList.clear();
        News news1 = new News(R.drawable.pic_entertainmet1,
                "天津自然博物馆",
                "cnsphoto.com",
                "2022-04-08 10:14",
                "http://www.cnsphoto.com/newDetail/single/12003176?pictureId=30869244");
        newsList.add(news1);
        News news2 = new News(R.drawable.pic_entertainmet2,
                "河北涿州：大漆髹饰技艺焕发新活力",
                "cnsphoto.com",
                "2022-04-08 09:43",
                "http://www.cnsphoto.com/newDetail/single/12031338?pictureId=31103344");
        newsList.add(news2);
        News news3 = new News(R.drawable.pic_entertainmet3,
                "安徽肥东：文化场馆建设忙",
                "cnsphoto.com",
                "2022-04-07 21:09",
                "http://www.cnsphoto.com/newDetail/single/12031098?pictureId=31102000");
        newsList.add(news3);
        News news4 = new News(R.drawable.pic_entertainmet4,
                "河北涿鹿：晋剧《劈山大渠》创排进行时",
                "cnsphoto.com",
                "2022-04-07 15:45",
                "http://www.cnsphoto.com/newDetail/single/12030522?pictureId=31097590");
        newsList.add(news4);
        News news5 = new News(R.drawable.pic_entertainmet5,
                "中国摄影报举办“大熊猫与自然”雅安摄影展在线新闻发布会",
                "cnsphoto.com",
                "2022-04-06 17:33",
                "http://www.cnsphoto.com/newDetail/single/12029506?pictureId=31089608");
        newsList.add(news5);
        News news6 = new News(R.drawable.pic_entertainmet6,
                "民众清明假期参观中国共产党历史展览馆",
                "cnsphoto.com",
                "2022-04-05 21:21",
                "http://www.cnsphoto.com/newDetail/single/12028706?pictureId=31083246");
        newsList.add(news6);
    }

    private void initNewsH() {
        newsList.clear();
        News news1 = new News(R.drawable.pic_health1,
                "（抗击新冠肺炎）天津增派中医医疗队驰援上海",
                "cnsphoto.com",
                "2022-04-11 16:39",
                "http://www.cnsphoto.com/newDetail/single/12036076?pictureId=31148810");
        newsList.add(news1);
        News news2 = new News(R.drawable.pic_health2,
                "山东枣庄：核酸检测快速有序推进",
                "cnsphoto.com",
                "2022-04-11 16:32",
                "http://www.cnsphoto.com/newDetail/single/12036152?pictureId=31149292");
        newsList.add(news2);
        News news3 = new News(R.drawable.pic_health3,
                "江苏苏州：有序开展核酸检测",
                "cnsphoto.com",
                "2022-04-11 16:28",
                "http://www.cnsphoto.com/newDetail/single/12036038?pictureId=31148118");
        newsList.add(news3);
        News news4 = new News(R.drawable.pic_health4,
                "江苏南通：崇川区开展第9次全员核酸检测",
                "cnsphoto.com",
                ":2022-04-11 15:21",
                "http://www.cnsphoto.com/newDetail/single/12036138?pictureId=31149240");
        newsList.add(news4);
        News news5 = new News(R.drawable.pic_health5,
                "山西盐湖：中小学有序复学复课",
                "cnsphoto.com",
                "2022-04-11 15:04",
                "http://www.cnsphoto.com/newDetail/single/12036014?pictureId=31148072");
        newsList.add(news5);
        News news6 = new News(R.drawable.pic_health6,
                "河南洛阳：共享“城市绿肺”",
                "cnsphoto.com",
                "2022-04-11 14:59",
                "http://www.cnsphoto.com/newDetail/single/12035932?pictureId=31147532");
        newsList.add(news6);
    }

    private void initNewsSC() {
        newsList.clear();
        News news1 = new News(R.drawable.pic_science1,
                "南京玄武湖畔繁花满枝“倾泻”而下似“瀑布”",
                "cnsphoto.com",
                "2022-04-11 20:20",
                "http://www.cnsphoto.com/newDetail/single/12036320?pictureId=31150656");
        newsList.add(news1);
        News news2 = new News(R.drawable.pic_science2,
                "广西融安：云雾绕城景色美",
                "cnsphoto.com",
                "2022-04-11 19:28",
                "http://www.cnsphoto.com/newDetail/single/12036052?pictureId=31148328");
        newsList.add(news2);
        News news3 = new News(R.drawable.pic_science3,
                "河北邯郸：春燕衔泥生态美",
                "cnsphoto.com",
                "2022-04-11 19:26",
                "http://www.cnsphoto.com/newDetail/single/12036078?pictureId=31148836");
        newsList.add(news3);
        News news4 = new News(R.drawable.pic_science4,
                "青海西宁遭遇沙尘天气",
                "cnsphoto.com",
                "2022-04-11 19:00",
                "http://www.cnsphoto.com/newDetail/single/12036168?pictureId=31149360");
        newsList.add(news4);
        News news5 = new News(R.drawable.pic_science5,
                "河南许昌：城水相依 风景迷人",
                "cnsphoto.com",
                "2022-04-11 18:53",
                "http://www.cnsphoto.com/newDetail/single/12036046?pictureId=31148482");
        newsList.add(news5);
        News news6 = new News(R.drawable.pic_science6,
                "浙江三门：油菜花开醉游人",
                "cnsphoto.com",
                "2022-04-11 18:51",
                "http://www.cnsphoto.com/newDetail/single/12036060?pictureId=31148740");
        newsList.add(news6);

    }

    private void initNewsSP() {
        newsList.clear();
        News news1 = new News(R.drawable.pic_sport1,
                "美国高尔夫球大师赛：舍夫勒首次夺冠 “老虎”伍兹名列第47（配文）",
                "cnsphoto.com",
                "2022-04-11 18:56",
                "http://www.cnsphoto.com/newDetail/single/12036144?pictureId=31149256");
        newsList.add(news1);
        News news2 = new News(R.drawable.pic_sport2,
                "2022 F1澳大利亚大奖赛：勒克莱尔夺冠 周冠宇列第11名",
                "cnsphoto.com",
                "2022-04-10 21:39",
                "http://www.cnsphoto.com/newDetail/single/12034696?pictureId=31133514");
        newsList.add(news2);
        News news3 = new News(R.drawable.pic_sport3,
                "第十三届亚运会：中国女子体操队获得团体金牌",
                "cnsphoto.com",
                "2022-04-10 17:51",
                "http://www.cnsphoto.com/newDetail/single/11996892?pictureId=30817554");
        newsList.add(news3);
        News news4 = new News(R.drawable.pic_sport4,
                "浙江农林大学：志愿者学礼仪迎亚运",
                "cnsphoto.com",
                "2022-04-10 16:04",
                "http://www.cnsphoto.com/newDetail/single/12034156?pictureId=31128478");
        newsList.add(news4);
        News news5 = new News(R.drawable.pic_sport5,
                "2022年浙江省青少年武术（套路、散打）锦标赛甲组比赛举行",
                "cnsphoto.com",
                "2022-04-09 15:20",
                "http://www.cnsphoto.com/newDetail/single/12033152?pictureId=31119428");
        newsList.add(news5);
        News news6 = new News(R.drawable.pic_sport6,
                "中国车手周冠宇征战F1澳大利亚大奖赛",
                "cnsphoto.com",
                "2022-04-08 17:51",
                "http://www.cnsphoto.com/newDetail/single/12031950?pictureId=31109186");
        newsList.add(news6);
    }
}
