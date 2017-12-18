/**
 *
 * Copyright (c) 2017-2017 SLICE project team (yhsuh@etri.re.kr)
 * http://slice.etri.re.kr
 *
 * This file is part of The SLICE components
 *
 * This Program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This Program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with The SLICE components; see the file COPYING.  If not, see
 * <http://www.gnu.org/licenses/>.
 */
package org.etri.slice.api.device;

import java.util.List;

import org.apache.edgent.execution.Job;
import org.apache.edgent.execution.Submitter;
import org.apache.edgent.topology.TStream;
import org.apache.edgent.topology.Topology;
import org.apache.edgent.topology.TopologyProvider;

public interface Device extends Submitter<Topology, Job>, TopologyProvider, ServiceContainer {

	String getGroupId();
	String getArtifactId();
	String getVersion();
	
	void addTStream(String topic, TStream<?> stream);
	TStream<?> getTStream(String topic);
	List<TStream<?>> getTStreamAll();	
}