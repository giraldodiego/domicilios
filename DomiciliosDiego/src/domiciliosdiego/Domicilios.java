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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Domicilios {
    public static double distance(Double lat1, Double lng1, 
                                      Double lat2, Double lng2){
     double a = (lat1-lat2)*Domicilios.distPerLat(lat1);
     double b = (lng1-lng2)*Domicilios.distPerLng(lat1);
     return Math.sqrt(a*a+b*b);
    }

    private static double distPerLng(double lat){
      return 0.0003121092*Math.pow(lat, 4)
             +0.0101182384*Math.pow(lat, 3)
                 -17.2385140059*lat*lat
             +5.5485277537*lat+111301.967182595;
    }

    private static double distPerLat(double lng){
            return -0.000000487305676*Math.pow(lng, 4)
                -0.0033668574*Math.pow(lng, 3)
                +0.4601181791*lng*lng
                -1.4558127346*lng+110579.25662316;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         List<Vertex> nodes;
         List<Edge> edges;
       Scanner scn = new Scanner(System.in);
       String str=scn.nextLine();
       String dots[];
       dots = new String[500];
       Dot points[];
       
Pattern p = Pattern.compile("([-]?\\d+(?:\\.\\d+))");
Matcher m = p.matcher(str);
int i = 0;
while(m.find())
{
    dots[i]= m.group(1);
    i++;
}
int j=0;
while(dots[j]!=null){
    j++;
}
dots[j-1]=null;
dots[j-2]=null;
points = new Dot[(j/2)-1];
j=0;
i=0;
while(dots[j]!=null&&dots[j+1]!=null){
    points[i]= new Dot(i, Double.parseDouble(dots[j]), Double.parseDouble(dots[j+1]));
    System.out.println(points[i].pos);
    i++;
    j+=2;
}
nodes = new ArrayList<Vertex>();
edges = new ArrayList<Edge>();
for(i=0;i<points.length;i++){
Vertex v = new Vertex(String.valueOf(i));
nodes.add(v);
}
int id=0;
for(i=0;i<points.length;i++){
for(j=0;j<points.length;j++){
    double w = Domicilios.distance(points[i].lat,points[i].lng,points[j].lat,points[j].lng);
Edge lane = new Edge(id,nodes.get(i), nodes.get(j), (int) w );
                edges.add(lane);
                id++;
}
}
Graph graph = new Graph(nodes, edges);
DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
                dijkstra.execute(nodes.get(0));
                LinkedList<Vertex> path = dijkstra.getPath(nodes.get(nodes.size()-1));
 for(j=0;j<path.size();j++){
     System.out.println(path.size());
System.out.println(path.get(j).getId());
 }
    }}