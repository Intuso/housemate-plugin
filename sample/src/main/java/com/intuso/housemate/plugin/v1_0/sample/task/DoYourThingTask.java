package com.intuso.housemate.plugin.v1_0.sample.task;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.intuso.housemate.client.v1_0.real.api.RealTask;
import com.intuso.housemate.client.v1_0.real.api.factory.task.RealTaskOwner;
import com.intuso.housemate.comms.v1_0.api.payload.TaskData;
import com.intuso.housemate.plugin.v1_0.api.TypeInfo;
import com.intuso.utilities.listener.ListenersFactory;
import com.intuso.utilities.log.Log;

@TypeInfo(id = "do-your-thing", name = "Do Your Thing", description = "Special task that does your thing")
public class DoYourThingTask extends RealTask {

    @Inject
    public DoYourThingTask(Log log,
                           ListenersFactory listenersFactory,
                           @Assisted TaskData data,
                           @Assisted RealTaskOwner owner) {
        super(log, listenersFactory, "do-your-thing", data, owner);
    }

    @Override
    protected void execute() {
        // do whatever thing it is you do
    }
}
