package jp.bap.demo.powerManager.controller;

import jp.bap.demo.powerManager.model.Company;
import jp.bap.demo.powerManager.model.Device;
import jp.bap.demo.powerManager.service.ConpanyService;
import jp.bap.demo.powerManager.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class DeviceController {
    @Autowired
    DeviceService deviceService;
    @Autowired
    ConpanyService conpanyService;
    @GetMapping("/devices")
    List<Device>get(){
        List<Device> devices = deviceService.getDevice();
        return devices;
    }
    @PostMapping("/device/post")
    Device device(@RequestBody Map<String,String>body){
        String idDevice = body.get( "idDevice" );
        int id = Integer.parseInt( idDevice );
        String code = body.get( "code" );
        String name = body.get( "name");
        String idCompany = body.get( "idCompany" );
        int idconpany = Integer.parseInt( idCompany );
        Company company = conpanyService.get( idconpany );
        Device device = new Device(  );
        device.setId( id );
        device.setCode( code );
        device.setName( name );
        device.setCompany( company );
        return deviceService.save( device );

    }
    @PutMapping("device/put/{id}")
    Device device(@PathVariable int id,@RequestBody Map<String,String>body) {
        String code = body.get( "code" );
        String name = body.get( "name" );
        String idCompany = body.get( "idCompany" );
        int idconpany = Integer.parseInt( idCompany );
        Company company = conpanyService.get( idconpany );
        Device device = new Device();
        device.setId( id );
        device.setCode( code );
        device.setName( name );
        device.setCompany( company );
        return deviceService.save( device );
    }
        @DeleteMapping("/deleteDevice/{id}")
                void device1(@PathVariable int id){
              deviceService.delete( id );
        }





}
