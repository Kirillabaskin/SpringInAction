package tacos.kitchen.messaging.jms;

import tacos.Order;

public interface OrderReceiver {

    Order receiveOrder();
}
