---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':question:'
    path: library/PathRestoration.java
    title: library/PathRestoration.java
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: library/TemplateDijkstra_pathEdge_test.java
    title: library/TemplateDijkstra_pathEdge_test.java
  - icon: ':x:'
    path: library/TemplateDijkstra_test.java
    title: library/TemplateDijkstra_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 68, in bundle\n    raise RuntimeError('bundler is not specified: {}'.format(str(path)))\n\
    RuntimeError: bundler is not specified: library/TemplateDijkstra.java\n"
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\nimport\
    \ library.AbstractGraph;\nimport library.PathRestoration;\n\nfinal class TemplateDijkstra<T\
    \ extends Comparable<T>> {\n\tprivate final class Dist implements Comparable<Dist>\
    \ {\n\t\tpublic int target;\n\t\tpublic T cost;\n\t\tpublic Dist(final int target,\
    \ final T cost) { this.target = target; this.cost = cost; }\n\t\t@Override public\
    \ final String toString() { return \" - \"+cost.toString()+\" -> \"+target; }\n\
    \t\t@Override public final int hashCode() { return Objects.hash(target, cost);\
    \ }\n\t\t@Override\n\t\t@SuppressWarnings(\"unchecked\")\n\t\tpublic final boolean\
    \ equals(final Object obj) {\n\t\t\tif(this == obj) return true;\n\t\t\tif(obj\
    \ == null) return false;\n\t\t\tif(this.getClass() != obj.getClass()) return false;\n\
    \t\t\tDist that = (Dist) obj;\n\t\t\tif(this.target != that.target) return false;\n\
    \t\t\tif(this.cost != that.cost) return false;\n\t\t\treturn true;\n\t\t}\n\t\t\
    @Override\n\t\tpublic final int compareTo(final Dist that) {\n\t\t\tint c = cmp.compare(this.cost,\
    \ that.cost);\n\t\t\tif(c == 0) c = Integer.compare(this.target, that.target);\n\
    \t\t\treturn c;\n\t\t}\n\t}\n\n\tprivate int prv[];\n\tprivate TemplateEdge<T>\
    \ prvEdge[];\n\tprivate Supplier<T> eSupplier;\n\tprivate T e;\n\tprivate BinaryOperator<T>\
    \ f;\n\tprivate Comparator<T> cmp;\n\n\tpublic TemplateDijkstra(final Supplier<T>\
    \ eSupplier, final BinaryOperator<T> f, final Comparator<T> cmp) {\n\t\tthis.eSupplier\
    \ = eSupplier;\n\t\tthis.e = eSupplier.get();\n\t\tthis.f = f;\n\t\tthis.cmp =\
    \ cmp;\n\t}\n\n\t// O((E+V)logV)\n\tpublic final <Node extends TemplateNode<T>>\
    \ ArrayList<T> dist(final TemplateGraph<T, Node> g, final int start) { return\
    \ dist(g, start, false); }\n\tpublic final <Node extends TemplateNode<T>> ArrayList<T>\
    \ dist(final TemplateGraph<T, Node> g, final int start, final boolean memoize)\
    \ { return dist(g.numNode, g.nodes(), start, memoize); }\n\tpublic final ArrayList<T>\
    \ dist(final int numNode, final TemplateNode<T>[] nodes, final int start) { return\
    \ dist(numNode, nodes, start, false); }\n\t@SuppressWarnings(\"unchecked\")\n\t\
    public final ArrayList<T> dist(final int numNode, final TemplateNode<T>[] nodes,\
    \ final int start, final boolean memoize) {\n\t\tSimpleUtil.rangeCheck(start,\
    \ numNode);\n\t\tfinal ArrayList<T> dist = new ArrayList<>(numNode);\n\t\tif(memoize)\
    \ {\n\t\t\tprv = new int[numNode];\n\t\t\tArrays.fill(prv, -1);\n\t\t\tprvEdge\
    \ = new TemplateEdge[numNode];\n\t\t}\n\t\tQueue<Dist> q = new PriorityQueue<>();\n\
    \n\t\tfor(int i = 0; i < numNode; i ++) dist.add(null);\n\t\tdist.set(start, eSupplier.get());\n\
    \t\tq.add(new Dist(start, dist.get(start)));\n\t\twhile(!q.isEmpty()) {\n\t\t\t\
    Dist crt = q.poll();\n\t\t\tif(cmp.compare(dist.get(crt.target), crt.cost) < 0)\
    \ continue;\n\t\t\tT tmp = dist.get(crt.target);\n\t\t\tfor(TemplateEdge<T> e\
    \ : nodes[crt.target]) {\n\t\t\t\tT updated = f.apply(tmp, e.cost);\n\t\t\t\t\
    if(dist.get(e.target) == null || cmp.compare(dist.get(e.target), updated) > 0)\
    \ {\n\t\t\t\t\tdist.set(e.target, updated);\n\t\t\t\t\tq.add(new Dist(e.target,\
    \ updated));\n\t\t\t\t\tif(memoize) {\n\t\t\t\t\t\tprv[e.target] = e.source;\n\
    \t\t\t\t\t\tprvEdge[e.target] = e;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\
    \treturn dist;\n\t}\n\n\tpublic final int[] path(final int start, final int goal)\
    \ { return PathRestoration.path(prv, start, goal); }\n\tpublic final ArrayTemplateNode<T>\
    \ pathEdge(final int start, final int goal) { return PathRestoration.pathEdge(new\
    \ ArrayTemplateNode<T>(-1), prv, prvEdge, start, goal); }\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  - library/PathRestoration.java
  isVerificationFile: false
  path: library/TemplateDijkstra.java
  requiredBy: []
  timestamp: '2022-10-03 14:19:18+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - library/TemplateDijkstra_test.java
  - library/TemplateDijkstra_pathEdge_test.java
documentation_of: library/TemplateDijkstra.java
layout: document
redirect_from:
- /library/library/TemplateDijkstra.java
- /library/library/TemplateDijkstra.java.html
title: library/TemplateDijkstra.java
---
