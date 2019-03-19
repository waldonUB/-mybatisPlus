package cn.ak.gc.threadTest;

public class ExecuteDemo {
//    public String queryHouses(String body) {
//        JSONObject temp = JSON.parseObject(body);
//        String param = temp.getJSONObject("paramMap").getString("buildingId");
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//
//        List<Future<List<Object>>> futureList = new ArrayList<>();
//        final SecurityContext securityContext = SecurityContextHolder.getContext();
//        final Map<String, String> mdcMap = MDCUtils.getMapFromMDC();
//        mdcMap.put("Authorization", MDC.get("Authorization"));
//
//        Future<List<Object>> floorInfoListFuture = executorService.submit(() -> {
//            return queryHouseFloor(param);
//        });
//        Future<List<Object>> unitInfoListFuture = executorService.submit(() -> {
//            return queryHouseUnit(param);
//        });
//        Future<List<Object>> houseInfoListFuture = executorService.submit(() -> {
//            SecurityContextHolder.setContext(securityContext);
//            MDCUtils.setMDCFromMap(mdcMap);
//            return queryHouseBySql(temp.toJSONString(), HouseBasic.class);
//        });
//        futureList.add(floorInfoListFuture);
//        futureList.add(unitInfoListFuture);
//        futureList.add(houseInfoListFuture);
////    String result = sqlComputeSvcService.querySql(temp.toJSONString());
////    result = JSONObject.parseObject(result).getString("body");
////    logger.warn("查询房源结果房源：{}", result);
////    List<HouseBasic> houseBasicList = JSONObject.parseArray(result, HouseBasic.class);
////        .getJSONArray("body").toJavaList(HouseBasic.class);
////    houseInfoReturn.setHouseInfoList(houseBasicList);
//        HouseInfoReturn houseInfoReturn = new HouseInfoReturn();
//
//        futureList.stream().forEach(future -> {
//            try {
//                List<Object> objectList = future.get();
//                if (objectList != null && objectList.size() > 0) {
//                    Object o = objectList.get(0);
//                    if (o instanceof UnitInfo) {
//                        houseInfoReturn.setUnitInfoList(
//                                objectList.stream().map(obj -> (UnitInfo) obj).collect(Collectors.toList()));
//                    } else if (o instanceof FloorInfo) {
//                        houseInfoReturn.setFloorInfoList(
//                                objectList.stream().map(obj -> (FloorInfo) obj).collect(Collectors.toList()));
//                    } else {
//                        logger.info("房源数据" + objectList.size());
//                        houseInfoReturn.setHouseInfoList(
//                                objectList.stream().map(obj -> (HouseBasic) obj).collect(Collectors.toList()));
//                        if (getSalesNameConfig() == 1 ) {
//                            houseInfoReturn.getHouseInfoList().forEach(d -> {
//                                if(StringUtils.isEmpty(d.getSalesName())){
//                                    d.setSalesName(d.getName());
//                                }
//                            });
//                        }
//                    }
//                }
//            } catch (Exception ignored) {
//            }
//        });
//
//        if (!executorService.isShutdown()) {
//            executorService.shutdown();
//        }
//
//        return JSON.toJSONString(houseInfoReturn);
//    }
}
