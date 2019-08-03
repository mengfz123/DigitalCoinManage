package com.ivan.digitalCoinInvest.okexWebsocket;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ivan.digitalCoinInvest.websocket.MyWebSocket;
import com.okcoin.commons.okex.open.api.websocket.WebSocket;
import com.okcoin.commons.okex.open.api.websocket.WebSocketAdapter;
import com.okcoin.commons.okex.open.api.websocket.WebSocketClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class WebsocketTest {

    JSONObject msgObj = new JSONObject();

    //实时市场行情
    JSONArray coinNameSet=new JSONArray();
    JSONArray coinPriceSet = new JSONArray();
    JSONObject parseObj = new JSONObject();
    JSONObject returnObj = new JSONObject();
    //实时交易信息
    LinkedList timeList=new LinkedList();
    LinkedList buyList=new LinkedList();
    LinkedList sellList=new LinkedList();


    @Bean
    public void wsTest() {


        WebSocket ws = new WebSocketClient(new WebSocketAdapter() {
            @Override
            public void onTextMessage(WebSocket ws, String text) throws Exception {
                System.out.println("okexWebsocket message: " + text);
                msgObj = JSONObject.parseObject(text);
                String table = msgObj.getString("table");
                if("spot/trade".equals(table)){

                }else if("index/ticker".equals(table)){
                    text=getRealTimeMarketPrice(text);
                }

                MyWebSocket.sendInfo(text);
                if (text.contains("checksum")) {
                    boolean res = ws.checkSum(text);
                }
            }

            @Override
            public void onWebsocketOpen(WebSocket ws) {
                System.out.println("okexWebsocket open");

                //ws.subscribe("index/ticker:BTC-USD","index/ticker:ETH-USD","index/ticker:BTC-USD","index/ticker:LTC-USD");
                //订阅市场行情信息
                ws.subscribe("index/ticker:ETH-USD","index/ticker:LTC-USD","index/ticker:EOS-USD","index/ticker:ETC-USD","index/ticker:BCH-USD");
                //订阅交易信息
                ws.subscribe("spot/trade:ETH-USDT","spot/trade:LTC-USDT","spot/trade:EOS-USDT","spot/trade:ETC-USDT","spot/trade:BCH-USDT");
            }

            @Override
            public void handleCallbackError(WebSocket websocket, Throwable cause) {
                cause.printStackTrace();
            }


            @Override
            public void onWebsocketClose(WebSocket ws, int code) {
                System.out.println("okexWebsocket close code = " + code);
            }

            @Override
            public void onWebsocketPong(WebSocket ws) {
                System.out.println("receive pong");
            }
        });
        ws.connect();

    }

    /*获取实时交易行情*/
    public String getRealTimeTradeInfo(String text){



    }

        /*获取实时数字货币价格行情*/
    public String getRealTimeMarketPrice(String text){

        parseObj = JSONObject.parseObject(text);
        JSONArray data = parseObj.getJSONArray("data");
        if(data != null){
            Object instrument_id = data.getJSONObject(0).get("instrument_id");
            Object last = data.getJSONObject(0).get("last");

            if(coinNameSet.indexOf(instrument_id)==-1){
                coinNameSet.add(instrument_id);
            }
            coinPriceSet.set(coinNameSet.indexOf(instrument_id),last);

            returnObj.put("coinNameList",coinNameSet);
            returnObj.put("marktPrice",coinPriceSet);
            text=JSONObject.toJSONString(returnObj);
            return text;
        }
         return null;
    }

}
