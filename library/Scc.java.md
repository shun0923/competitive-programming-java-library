---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/Scc_graph_test.java
    title: library/Scc_graph_test.java
  - icon: ':heavy_check_mark:'
    path: library/Scc_groups_test.java
    title: library/Scc_groups_test.java
  - icon: ':heavy_check_mark:'
    path: library/Scc_ids_test.java
    title: library/Scc_ids_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\nimport\
    \ library.AbstractGraph;\n\nfinal class Scc {\n\tprivate static int ids[];\n\t\
    private static int numGroup;\n\n\t// O(V+E)\n\tpublic static final <Edge extends\
    \ AbstractEdge<Edge>> int[][] calGroups(final AbstractGraph<? extends AbstractNode<Edge>,\
    \ Edge> g) { return calGroups(g.numNode, g.numEdge(), g.nodes()); }\n\tpublic\
    \ static final int[][] calGroups(final int numNode, final int numEdge, final AbstractNode<?\
    \ extends AbstractEdge>[] nodes) {\n\t\tint ids[] = calIds(numNode, numEdge, nodes);\n\
    \t\tint len[] = new int[numGroup];\n\t\tfor(int x : ids) len[x] ++;\n\t\tint groups[][]\
    \ = new int[numGroup][];\n\t\tfor(int i = 0; i < numGroup; i ++) groups[i] = new\
    \ int[len[i]];\n\t\tArrays.fill(len, 0);\n\t\tfor(int i = 0; i < numNode; i ++)\
    \ groups[ids[i]][len[ids[i]] ++] = i;\n\t\treturn groups;\n\t}\n\tpublic static\
    \ final <Edge extends AbstractEdge<Edge>> HashUnweightedGraph calGraph(final AbstractGraph<?\
    \ extends AbstractNode<Edge>, Edge> g) { return calGraph(g.numNode, g.numEdge(),\
    \ g.nodes()); }\n\tpublic static final HashUnweightedGraph calGraph(final int\
    \ numNode, final int numEdge, final AbstractNode<? extends AbstractEdge>[] nodes)\
    \ {\n\t\tint ids[] = calIds(numNode, numEdge, nodes);\n\t\tHashUnweightedGraph\
    \ contracted = new HashUnweightedGraph(numGroup, true);\n\t\tfor(int i = 0; i\
    \ < numNode; i ++) {\n\t\t\tfor(AbstractEdge e : nodes[i]) {\n\t\t\t\tint s =\
    \ ids[e.source];\n\t\t\t\tint t = ids[e.target];\n\t\t\t\tif(s != t) contracted.add(s,\
    \ t);\n\t\t\t}\n\t\t}\n\t\treturn contracted;\n\t}\n\tpublic static final <Edge\
    \ extends AbstractEdge<Edge>> int[] calIds(final AbstractGraph<? extends AbstractNode<Edge>,\
    \ Edge> g) { return calIds(g.numNode, g.numEdge(), g.nodes()); }\n\tpublic static\
    \ final int[] calIds(final int numNode, final int numEdge, final AbstractNode<?\
    \ extends AbstractEdge>[] nodes) {\n\t\tint low[] = new int[numNode];\n\t\tint\
    \ ids[] = new int[numNode];\n\t\tint visited[] = new int[numNode];\n\t\tint ptr1\
    \ = 0;\n\t\tint stack[] = new int[numEdge + 1];\n\t\tint ptr2 = 0;\n\t\tint now\
    \ = 0;\n\t\tint numGroup = 0;\n\t\tArrays.fill(low, -1);\n\t\tfor(int i = 0; i\
    \ < numNode; i ++) {\n\t\t\tif(low[i] != -1) continue;\n\t\t\tstack[ptr2 ++] =\
    \ i;\n\t\t\twhile(ptr2 != 0) {\n\t\t\t\tint v = stack[-- ptr2];\n\t\t\t\tif(v\
    \ >= 0) {\n\t\t\t\t\tif(low[v] != -1) continue;\n\t\t\t\t\tlow[v] = now ++;\n\t\
    \t\t\t\tvisited[ptr1 ++] = v;\n\t\t\t\t\tstack[ptr2 ++] = - v - 1;\n\t\t\t\t\t\
    for(AbstractEdge e : nodes[v]) if(low[e.target] == -1) stack[ptr2 ++] = e.target;\n\
    \t\t\t\t}else {\n\t\t\t\t\tv = - v - 1;\n\t\t\t\t\tboolean root = true;\n\t\t\t\
    \t\tfor(AbstractEdge e : nodes[v]) if(low[v] > low[e.target]) { low[v] = low[e.target];\
    \ root = false; }\n\t\t\t\t\tif(root) {\n\t\t\t\t\t\twhile(true) {\n\t\t\t\t\t\
    \t\tint u = visited[-- ptr1];\n\t\t\t\t\t\t\tlow[u] = numNode;\n\t\t\t\t\t\t\t\
    ids[u] = numGroup;\n\t\t\t\t\t\t\tif(u == v) break;\n\t\t\t\t\t\t}\n\t\t\t\t\t\
    \tnumGroup ++;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\t\tfor(int i = 0; i\
    \ < numNode; i ++) ids[i] = numGroup - ids[i] - 1;\n\t\tScc.ids = ids;\n\t\tScc.numGroup\
    \ = numGroup;\n\t\treturn ids;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/Scc.java
  requiredBy: []
  timestamp: '2022-10-04 15:13:10+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/Scc_graph_test.java
  - library/Scc_groups_test.java
  - library/Scc_ids_test.java
documentation_of: library/Scc.java
layout: document
redirect_from:
- /library/library/Scc.java
- /library/library/Scc.java.html
title: library/Scc.java
---
