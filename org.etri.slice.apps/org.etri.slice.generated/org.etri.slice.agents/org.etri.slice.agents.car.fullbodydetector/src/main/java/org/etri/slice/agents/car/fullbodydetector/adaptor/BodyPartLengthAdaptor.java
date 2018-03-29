package org.etri.slice.agents.car.fullbodydetector.adaptor;

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
import org.etri.slice.agents.car.fullbodydetector.stream.BodyPartLengthStream;
import org.etri.slice.commons.car.context.BodyPartLength;

@Component
@Instantiate
public class BodyPartLengthAdaptor extends EventSubscriber<BodyPartLength> {
	
	private static final long serialVersionUID = 1759242242915190997L;

	@Property(name="topic", value=BodyPartLength.topic)
	private String m_topic;
	
	@Requires
	private WorkingMemory m_wm;

	@Requires
	private Agent m_agent;
	
	@Requires(from=BodyPartLengthStream.SERVICE_NAME)
	private EventStream<BodyPartLength> m_streaming;	
	
	protected  String getTopicName() {
		return m_topic;
	}
	
	protected WorkingMemory getWorkingMemory() {
		return m_wm;
	}
	
	protected Agent getAgent() {
		return m_agent;
	}
	
	protected EventStream<BodyPartLength> getEventStream() {
		return m_streaming;
	}
		
	@Subscriber(name="BodyPartLengthAdaptor", topics=BodyPartLength.topic,
			dataKey=BodyPartLength.dataKey, dataType=BodyPartLength.dataType)
	public void receive(BodyPartLength event) {
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

