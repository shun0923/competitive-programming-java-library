---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':warning:'
    path: library/FastIO.java
    title: library/FastIO.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/TemplateDijkstra_path_test.java
    title: library/TemplateDijkstra_path_test.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateDijkstra_test.java
    title: library/TemplateDijkstra_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n          \
    \         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 466, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 571, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.util.*;\nimport java.util.function.*;\nimport\
    \ library.FastIO;\nimport library.AbstractGraph;\n\nfinal class TemplateDijkstra<T>\
    \ {\n\tprivate final class Dist implements Comparable<Dist> {\n\t\tpublic int\
    \ target;\n\t\tpublic T cost;\n\t\tpublic Dist(final int target, final T cost)\
    \ { this.target = target; this.cost = cost; }\n\t\t@Override public final String\
    \ toString() { return \" - \"+cost.toString()+\" -> \"+target; }\n\t\t@Override\
    \ public final int hashCode() { return Objects.hash(target, cost); }\n\t\t@Override\n\
    \t\t@SuppressWarnings(\"unchecked\")\n\t\tpublic final boolean equals(final Object\
    \ obj) {\n\t\t\tif(this == obj) return true;\n\t\t\tif(obj == null) return false;\n\
    \t\t\tif(this.getClass() != obj.getClass()) return false;\n\t\t\tDist that = (Dist)\
    \ obj;\n\t\t\tif(this.target != that.target) return false;\n\t\t\tif(this.cost\
    \ != that.cost) return false;\n\t\t\treturn true;\n\t\t}\n\t\t@Override\n\t\t\
    public final int compareTo(final Dist that) {\n\t\t\tint c = cmp.compare(this.cost,\
    \ that.cost);\n\t\t\tif(c == 0) c = Integer.compare(this.target, that.target);\n\
    \t\t\treturn c;\n\t\t}\n\t}\n\n\tprivate Supplier<T> eSupplier;\n\tprivate T e;\n\
    \tprivate BinaryOperator<T> f;\n\tprivate Comparator<T> cmp;\n\n\tpublic TemplateDijkstra(final\
    \ Supplier<T> eSupplier, final BinaryOperator<T> f, final Comparator<T> cmp) {\n\
    \t\tthis.eSupplier = eSupplier;\n\t\tthis.e = eSupplier.get();\n\t\tthis.f = f;\n\
    \t\tthis.cmp = cmp;\n\t}\n\n\t// O((E+V)logV)\n\tpublic final <Graph extends AbstractGraph<?\
    \ extends TemplateNode<T>, TemplateEdge<T>>> ArrayList<T> dist(final Graph g,\
    \ final int start) { return dist(g, start, null, null); }\n\tpublic final <Graph\
    \ extends AbstractGraph<? extends TemplateNode<T>, TemplateEdge<T>>> ArrayList<T>\
    \ dist(final Graph g, final int start, final int[] prv) { return dist(g, start,\
    \ prv, null); }\n\tpublic final <Graph extends AbstractGraph<? extends TemplateNode<T>,\
    \ TemplateEdge<T>>> ArrayList<T> dist(final Graph g, final int start, final int[]\
    \ prv, final TemplateEdge<T>[] prvEdge) { return dist(g.numNode, g.nodes(), start,\
    \ prv, prvEdge); }\n\tpublic final ArrayList<T> dist(final int numNode, final\
    \ TemplateNode<T>[] nodes, final int start) { return dist(numNode, nodes, start,\
    \ null, null); }\n\tpublic final ArrayList<T> dist(final int numNode, final TemplateNode<T>[]\
    \ nodes, final int start, final int[] prv) { return dist(numNode, nodes, start,\
    \ prv, null); }\n\tpublic final ArrayList<T> dist(final int numNode, final TemplateNode<T>[]\
    \ nodes, final int start, final int[] prv, final TemplateEdge<T>[] prvEdge) {\n\
    \t\tFastIO.rangeCheck(start, numNode);\n\t\tfinal ArrayList<T> dist = new ArrayList<>(numNode);\n\
    \t\tif(prv != null) Arrays.fill(prv, -1);\n\t\tQueue<Dist> q = new PriorityQueue<>();\n\
    \n\t\tfor(int i = 0; i < numNode; i ++) dist.add(null);\n\t\tdist.set(start, eSupplier.get());\n\
    \t\tq.add(new Dist(start, dist.get(start)));\n\t\twhile(!q.isEmpty()) {\n\t\t\t\
    Dist crt = q.poll();\n\t\t\tif(cmp.compare(dist.get(crt.target), crt.cost) < 0)\
    \ continue;\n\t\t\tT tmp = dist.get(crt.target);\n\t\t\tfor(TemplateEdge<T> e\
    \ : nodes[crt.target]) {\n\t\t\t\tT updated = f.apply(tmp, e.cost);\n\t\t\t\t\
    if(dist.get(e.target) == null || cmp.compare(dist.get(e.target), updated) > 0)\
    \ {\n\t\t\t\t\tdist.set(e.target, updated);\n\t\t\t\t\tq.add(new Dist(e.target,\
    \ updated));\n\t\t\t\t\tif(prv != null) prv[e.target] = e.source;\n\t\t\t\t\t\
    if(prvEdge != null) prvEdge[e.target] = e;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn\
    \ dist;\n\t}\n}"
  dependsOn:
  - library/FastIO.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/TemplateDijkstra.java
  requiredBy: []
  timestamp: '2023-03-24 01:50:05+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/TemplateDijkstra_test.java
  - library/TemplateDijkstra_path_test.java
documentation_of: library/TemplateDijkstra.java
layout: document
redirect_from:
- /library/library/TemplateDijkstra.java
- /library/library/TemplateDijkstra.java.html
title: library/TemplateDijkstra.java
---
