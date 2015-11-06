package com.containersol.minimesos.mesos;

import com.containersol.minimesos.container.AbstractContainer;
import org.junit.Test;

import static com.containersol.minimesos.mesos.ClusterContainers.*;
import static org.mockito.Mockito.*;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests
 */
public class ClusterContainersTest {
    @Test
    public void shouldEmptyStart() {
        assertTrue(new ClusterContainers().getContainers().isEmpty());
    }

    @Test
    public void shouldAllowInjection() {
        List dummyList = mock(List.class);
        assertEquals(dummyList, new ClusterContainers(dummyList).getContainers());
    }

    @Test
    public void shouldFilterZooKeeper() {
        ZooKeeper mock = mock(ZooKeeper.class);
        AbstractContainer abstractContainer = mock(AbstractContainer.class);
        ClusterContainers clusterContainers = new ClusterContainers();
        clusterContainers.add(mock).add(abstractContainer);

        assertTrue(clusterContainers.isPresent(Filter.zooKeeper()));
    }

    @Test
    public void shouldFilterMesosMaster() {
        MesosMaster mock = mock(MesosMaster.class);
        AbstractContainer abstractContainer = mock(AbstractContainer.class);
        ClusterContainers clusterContainers = new ClusterContainers();
        clusterContainers.add(mock).add(abstractContainer);

        assertTrue(clusterContainers.isPresent(Filter.mesosMaster()));
    }

    @Test
    public void shouldFilterMesosSlave() {
        MesosSlave mock = mock(MesosSlave.class);
        AbstractContainer abstractContainer = mock(AbstractContainer.class);
        ClusterContainers clusterContainers = new ClusterContainers();
        clusterContainers.add(mock).add(abstractContainer);

        assertTrue(clusterContainers.isPresent(Filter.mesosSlave()));
    }
}