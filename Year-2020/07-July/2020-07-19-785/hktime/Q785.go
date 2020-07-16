/*
* @Author: HK
* @Date:   2020-07-16 23:09:57
* @Last Modified by:   HK
* @Last Modified time: 2020-07-16 23:10:28
*/
// DFS
const (
    UNCOLORED = 0
    RED = 1
    GREEN = 2
)
var (
    colors []int
    valid  bool
)
func isBipartite(graph [][]int) bool {
    n := len(graph)
    colors = make([]int, n)
    valid = true
    for i := 0; i < n && valid; i++{
        if colors[i] == UNCOLORED{
            dfs(i, RED, graph)
        }
    }
    return valid
}

func dfs(node, color int, graph [][]int){
    colors[node] = color
    cNow := RED
    if color == RED{
        cNow = GREEN
    }
    for _, neigh := range graph[node]{
        if colors[neigh] == UNCOLORED{
            dfs(neigh, cNow, graph)
            if !valid{
                return
            }
        }else if colors[neigh] != cNow{
            valid = false
            return
        }
    }
}
// bfs
const (
    UNCOLORED = 0
    RED = 1
    GREEN = 2
)
func isBipartite(graph [][]int) bool {
    n := len(graph)
    colors := make([]int, n)
    for i := 0; i < n; i++{
        if colors[i] == UNCOLORED{
            queues := []int{i}
            colors[i] = RED
            for j := 0; j < len(queues); j++{
                node := queues[j]
                cNow := RED
                if colors[node] == RED{
                    cNow = GREEN
                }
                for _, neigh := range graph[node]{
                    if colors[neigh] == UNCOLORED{
                        colors[neigh] = cNow
                        queues = append(queues, neigh)
                    }else if colors[neigh] != cNow{
                        return false
                    }
                }
            }
        }
    }
    return true
}