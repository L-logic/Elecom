package org.csu.electriccommerce.controller;


import org.csu.electriccommerce.entity.Cloud;
import org.csu.electriccommerce.entity.Hunhe;
import org.csu.electriccommerce.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("/cloud")
public class CloudController {


    @Autowired
    private MainService mainService;

    @RequestMapping("/getCloud")
    @ResponseBody
    public ArrayList<Cloud> getCloud(@RequestParam("word") String word , Model model ){
        ArrayList<Hunhe> arrayList = mainService.findComp(word);
        ArrayList<Cloud> clouds = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            Cloud cloud = new Cloud();
            cloud.setName(arrayList.get(i).getCompkey());
            cloud.setValue(arrayList.get(i).getCompPower()*20);
            clouds.add(cloud);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            Cloud cloud = new Cloud();
            cloud.setName(arrayList.get(i).getCompkey());
            cloud.setValue(arrayList.get(i).getCompPower()*40);
            clouds.add(cloud);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            Cloud cloud = new Cloud();
            cloud.setName(arrayList.get(i).getCompkey());
            cloud.setValue(arrayList.get(i).getCompPower()*50);
            clouds.add(cloud);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            Cloud cloud = new Cloud();
            cloud.setName(arrayList.get(i).getCompkey());
            cloud.setValue(arrayList.get(i).getCompPower()*80);
            clouds.add(cloud);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            Cloud cloud = new Cloud();
            cloud.setName(arrayList.get(i).getCompkey());
            cloud.setValue(arrayList.get(i).getCompPower()*100);
            clouds.add(cloud);
        }
        return clouds;
    }
}
