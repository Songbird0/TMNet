package fr.skyforce77.tmnet.components;

import java.util.LinkedList;
import java.util.List;

import fr.skyforce77.tmnet.packet.Packet;
import fr.skyforce77.tmnet.packet.PacketData;
import fr.skyforce77.tmnet.packet.PacketSerializer;
import fr.skyforce77.tmnet.pipes.PacketDataPipe;
import fr.skyforce77.tmnet.pipes.PacketPipe;

public abstract class Node {
	
	private PacketSerializer serializer;
	private List<PacketPipe> packetPipes;
	private List<PacketDataPipe> dataPipes;
	
	public Node() {
		serializer = new PacketSerializer();
		packetPipes = new LinkedList<>();
		dataPipes = new LinkedList<>();
	}
	
	protected void receive(PacketData data) {
		dataPipes.forEach(pipe -> {
			pipe.in(data);
		});
		Packet packet = serializer.unserialize(data);
		if(packet != null) {
			packetPipes.forEach(pipe -> {
				pipe.in(packet);
			});
			
			// TODO handle packet
		}
	}
	
	protected void send(Packet packet) {
		packetPipes.forEach(pipe -> {
			pipe.in(packet);
		});
		PacketData data = serializer.serialize(packet);
		if(data != null) {
			dataPipes.forEach(pipe -> {
				pipe.in(data);
			});
			
			// TODO send data
		}
	}

}
