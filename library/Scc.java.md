---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':warning:'
    path: library/FastIO.java
    title: library/FastIO.java
  _extendedRequiredBy:
  - icon: ':warning:'
    path: library/TwoSat.java
    title: library/TwoSat.java
  _extendedVerifiedWith:
  - icon: ':x:'
    path: library/Scc_graph_test.java
    title: library/Scc_graph_test.java
  - icon: ':x:'
    path: library/Scc_groups_test.java
    title: library/Scc_groups_test.java
  - icon: ':x:'
    path: library/Scc_ids_test.java
    title: library/Scc_ids_test.java
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
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
  code: "package library;\n\nimport java.util.*;\nimport library.FastIO;\nimport library.AbstractGraph;\n\
    \nfinal class Scc {\n\tprivate static int ids[];\n\tprivate static int numGroup;\n\
    \n\t// O(V+E)\n\tpublic static final <Edge extends AbstractEdge<Edge>> int[][]\
    \ calGroups(final AbstractGraph<? extends AbstractNode<Edge>, Edge> g) { return\
    \ calGroups(g.numNode, g.numEdge(), g.nodes()); }\n\tpublic static final int[][]\
    \ calGroups(final int numNode, final int numEdge, final AbstractNode<? extends\
    \ AbstractEdge>[] nodes) {\n\t\tint ids[] = calIds(numNode, numEdge, nodes);\n\
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
  - library/FastIO.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/Scc.java
  requiredBy:
  - library/TwoSat.java
  timestamp: '2023-03-23 19:06:36+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - library/Scc_graph_test.java
  - library/Scc_ids_test.java
  - library/Scc_groups_test.java
documentation_of: library/Scc.java
layout: document
redirect_from:
- /library/library/Scc.java
- /library/library/Scc.java.html
title: library/Scc.java
---