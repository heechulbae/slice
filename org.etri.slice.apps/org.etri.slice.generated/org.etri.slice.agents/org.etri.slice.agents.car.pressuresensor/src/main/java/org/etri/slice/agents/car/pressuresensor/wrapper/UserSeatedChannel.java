package org.etri.slice.agents.car.pressuresensor.wrapper;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Invalidate;
import org.apache.felix.ipojo.annotations.Property;
import org.apache.felix.ipojo.annotations.Requires;
import org.apache.felix.ipojo.annotations.Validate;
import org.etri.slice.api.agent.Agent;
import org.etri.slice.api.inference.WorkingMemory;
import org.etri.slice.api.perception.EventStream;
import org.etri.slice.core.perception.MqttEventPublisher;
import org.etri.slice.agents.car.pressuresensor.stream.UserSeatedStream;
import org.etri.slice.commons.car.event.UserSeated;

@Component
@Instantiate
public class UserSeatedChannel extends MqttEventPublisher<UserSeated> {

	private static final long serialVersionUID = 3453050586994724050L;

	@Property(name="topic", value=UserSeated.TOPIC)
	private String m_topic;
	
	@Property(name="url", value="tcp://129.254.88.119:1883")
	private String m_url;
	
	@Requires
	private WorkingMemory m_wm;

	@Requires
	private Agent m_agent;
	
	@Requires(from=UserSeatedStream.SERVICE_NAME)
	private EventStream<UserSeated> m_streaming;		
	
	protected  String getTopicName() {
		return m_topic;
	}
	
	protected String getMqttURL() {
		return m_url;
	}	
	
	protected WorkingMemory getWorkingMemory() {
		return m_wm;
	}
	
	protected Agent getAgent() {
		return m_agent;
	}
	
	protected EventStream<UserSeated> getEventStream() {
		return m_streaming;
	}	
		
	@Validate
	public void start() {
		super.start();
	}
	
	@Invalidate
	public void stop() {
		super.stop();
	}
}

