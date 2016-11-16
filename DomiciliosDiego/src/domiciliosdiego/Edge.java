/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domiciliosdiego;

/**
 *
 * @author Diego Giraldo
 */
public class Edge{
        private final int id;
        private final Vertex source;
        private final Vertex destination;
        private final int weight;

        public Edge(int id, Vertex source, Vertex destination, int weight) {
                this.id = id;
                this.source = source;
                this.destination = destination;
                this.weight = weight;
        }

        public int getId() {
                return id;
        }
        public Vertex getDestination() {
                return destination;
        }

        public Vertex getSource() {
                return source;
        }
        public int getWeight() {
                return weight;
        }

        @Override
        public String toString() {
                return source + " " + destination;
        }


}
