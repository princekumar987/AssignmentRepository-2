import java.util.ArrayList;
import java.util.List;

interface ISubscriber{
    void update();
}

// Observable interface: a YouTube channel interface

interface IChannel{
    void subscribe(ISubscriber subscriber);
    void unsubscribe(ISubscriber subscriber);
    void notifySubscribers();
}

// Concrete Subject: a YouTube channel that observers can subscribe to

class Channel implements  IChannel{

    private List<ISubscriber>subscribers;
    private String name;
    private String latestVideo;

    public Channel(String name){
        this.subscribers=new ArrayList<>();
        this.name=name;
    }

    @Override
    public void subscribe(ISubscriber subscriber) {
        if(!subscribers.contains((subscriber))){
            subscribers.add(subscriber);
        }
    }

    @Override
    public void unsubscribe(ISubscriber subscriber) {
        if(subscribers.contains(subscriber)){
            subscribers.remove(subscriber);
        }
    }

    @Override
    public void notifySubscribers() {

        for(ISubscriber e:subscribers){
            e.update();
        }

    }

    public void uploadVideo(String video){
        latestVideo=video;
        System.out.println(name+":-> New Video is Upload:--"+latestVideo);
        notifySubscribers();
    }

    public String getLatestVideo(){
        return "new Video is "+latestVideo;
    }
}

class Subscriber implements ISubscriber{
    private String name;
    private Channel channel;

    public Subscriber(String name, Channel channel){
        this.name=name;
        this.channel=channel;
    }

    @Override
    public void update() {
        System.out.println("hello jii "+name+" "+channel.getLatestVideo());
    }
}



public class ObserverDesignPattern {
    public static void main(String[] args) {

        Channel channel=new Channel("ProgrammerChannel");

        Subscriber sb1=new Subscriber("Raj",channel);
        Subscriber sb2=new Subscriber("Piyush",channel);

        // subscribe the channel by both users
        channel.subscribe(sb1);
        channel.subscribe(sb2);

        //upload video:--
        channel.uploadVideo("Java New Video Upload");

        //unsubscribe by Raj
        channel.unsubscribe(sb1);

        //Another new Video Upload:------
        channel.uploadVideo("C++ New Video Upload");



    }
}
