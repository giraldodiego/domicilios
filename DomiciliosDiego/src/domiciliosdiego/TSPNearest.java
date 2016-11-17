/*
 This code is a modified algorithm based on http://www.sanfoundry.com/java-program-implement-traveling-salesman-problem-using-nearest-neighbour-algorithm/
 */

package domiciliosdiego;

/**
 *
 * @author Diego
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
 
public class TSPNearest
{
    private int numberOfNodes;
    private Stack<Integer> stack;
 
    public TSPNearest()
    {
        stack = new Stack<Integer>();
    }
 
    public List<Integer> tsp(int adjacencyMatrix[][])
    {
        numberOfNodes = adjacencyMatrix.length;
        int[] visited = new int[numberOfNodes];
        List<Integer> shortestPath;
        shortestPath = new ArrayList<>();
        visited[0] = 1;
        shortestPath.add(stack.push(0));
        int element, dst = 0, i;
        int min = Integer.MAX_VALUE;
        boolean minFlag = false;
 
        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = 0;
            min = Integer.MAX_VALUE;
            while (i < numberOfNodes)
            {
                if (adjacencyMatrix[element][i] > 0 && visited[i] == 0)
                {
                    if (min > adjacencyMatrix[element][i])
                    {
                        min = adjacencyMatrix[element][i];
                        dst = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag)
            {
                visited[dst] = 1;
                shortestPath.add(stack.push(dst));
                minFlag = false;
                continue;
            }
            stack.pop();
        }
        return shortestPath;
    }
    

    
}