package org.etri.slice.agents.car.pressuresensor.adaptor;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Property;
import org.apache.felix.ipojo.annotations.Requires;
import org.apache.felix.ipojo.annotations.Validate;
import org.apache.felix.ipojo.handlers.event.Subscriber;
import org.etri.slice.api.agent.Agent;
import org.etri.slice.api.inference.WorkingMemory;
import org.etri.slice.api.perception.EventStream;
import org.etri.slice.core.perception.EventSubscriber;
import org.etri.slice.agents.car.pressuresensor.stream.PressureStream;
import org.etri.slice.commons.car.context.Pressure;

@Component
@Instantiate
public class PressureAdaptor extends EventSubscriber<Pressure> {
	
	private static final long serialVersionUID = 553476557315788520L;

	@Property(name="topic", value=Pressure.topic)
	private String m_topic;
	
	@Requires
	private WorkingMemory m_wm;

	@Requires
	private Agent m_agent;
	
	@Requires(from=PressureStream.SERVICE_NAME)
	private EventStream<Pressure> m_streaming;	
	
	protected  String getTopicName() {
		return m_topic;
	}
	
	protected WorkingMemory getWorkingMemory() {
		return m_wm;
	}
	
	protected Agent getAgent() {
		return m_agent;
	}
	
	protected EventStream<Pressure> getEventStream() {
		return m_streaming;
	}
		
	@Subscriber(name="PressureAdaptor", topics=Pressure.topic,
			dataKey=Pressure.dataKey, dataType=Pressure.dataType)
	public void receive(Pressure event) {
		super.subscribe(event);
	}
	
	@Validate
	public void start() {
		super.start(event -> m_wm.insert(event));
	}
	
	@Invalidate
	public void stop() {
		super.stop();
	}
}		

