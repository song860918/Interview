package ds.graph;

import org.junit.Test;
import util.TestUtil;

public class GraphSearchTest {

    private GraphSearch<Character> graphSearch = new GraphSearch<>();

    @Test
    public void dfsTwoNodesTest() {
        GraphNode<Character> graph = TestUtil.characterGraph("ab".toCharArray(), 'a', "a->b");
        graphSearch.dfs(graph);
        graphSearch.dfsWithNoSet(graph);
    }

    @Test
    public void dfsMultipleNodesTest() {
        GraphNode<Character> graph = TestUtil.characterGraph("sbcdefghijk".toCharArray(), 's', "s->b,s->c,b->e,b->d,c->d,c->g,e->f,f->i,f->h,h->k,d->j,j->k");
        graphSearch.dfs(graph);
        graphSearch.dfsWithNoSet(graph);
    }

    @Test(expected = RuntimeException.class)
    public void cycleTest() {
        GraphNode<Character> graph = TestUtil.characterGraph("sbcdefghijk".toCharArray(), 's', "s->b,s->c,b->e,b->d,c->d,c->g,e->f,f->i,f->h,h->k,d->j,j->k,i->b");
        graphSearch.dfs(graph);
        //Expect to throw RuntimeException
        graphSearch.dfsWithNoSet(graph);
    }

    @Test
    public void bfsTest() {
        GraphNode<Character> graph = TestUtil.characterGraph("sbcdefghijk".toCharArray(), 's', "s->b,s->c,b->e,b->d,c->d,c->g,e->f,f->i,f->h,h->k,d->j,j->k");
        graphSearch.bfs(graph);
    }
}
