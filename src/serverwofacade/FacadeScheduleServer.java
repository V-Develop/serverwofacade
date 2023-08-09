/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverwofacade;

/**
 *
 * @author alongkornvanzoh
 */
public class FacadeScheduleServer {
    private final ScheduleServer scheduleServer = new ScheduleServer();
    private static FacadeScheduleServer facadeScheduleServer = null;
    
    private FacadeScheduleServer() {}
    
    public static FacadeScheduleServer getFacadeScheduleServerObject() {
        if(facadeScheduleServer == null) {
            facadeScheduleServer = new FacadeScheduleServer();
        }
        return facadeScheduleServer;
    }
    
    public void startServer() {
	scheduleServer.startBooting();
	scheduleServer.readSystemConfigFile();
	scheduleServer.init();
	scheduleServer.initializeContext();
	scheduleServer.initializeListeners();
	scheduleServer.createSystemObjects();
	System.out.println("Start working......");
    }
    
    public void stopServer() {
        System.out.println("After work done.........");
	scheduleServer.releaseProcesses();
	scheduleServer.destory();
	scheduleServer.destroySystemObjects();
	scheduleServer.destoryListeners();
	scheduleServer.destoryContext();
	scheduleServer.shutdown();
    }
}
