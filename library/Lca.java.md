---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':warning:'
    path: library/FastIO.java
    title: library/FastIO.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/Lca_test.java
    title: library/Lca_test.java
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
  code: "package library;\n\nimport java.util.*;\nimport library.FastIO;\nimport library.AbstractGraph;\n\
    \nfinal class Lca {\n\tprivate final int numNode;\n\tprivate Doubling db;\n\t\
    public final int depth[];\n\n\t// O(VlogV)\n\tpublic <Edge extends AbstractEdge<Edge>>\
    \ Lca(final AbstractGraph<? extends AbstractNode<Edge>, Edge> g, final int root)\
    \ { this(g.numNode, g.nodes(), root); }\n\tpublic <Edge extends AbstractEdge<Edge>>\
    \ Lca(final int numNode, final AbstractNode<Edge>[] nodes, final int root) {\n\
    \t\tFastIO.nonNegativeCheck(numNode);\n\t\tFastIO.rangeCheck(root, numNode);\n\
    \t\tthis.numNode = numNode;\n\t\tdepth = new int[numNode];\n\t\tdb = new Doubling(numNode,\
    \ numNode, bfs(root, nodes));\n\t}\n\n\tprivate final <Edge extends AbstractEdge<Edge>>\
    \ int[] bfs(final int start, final AbstractNode<Edge>[] nodes) { // O(V)\n\t\t\
    int edges[] = new int[numNode];\n\t\tint stack[] = new int[numNode];\n\t\tint\
    \ ptr = 0;\n\t\tint size = 0;\n\n\t\tArrays.fill(depth, -1);\n\t\tdepth[start]\
    \ = 0;\n\t\tedges[start] = -1;\n\t\tdepth[start] = 0;\n\t\tstack[size ++] = 0;\n\
    \t\twhile(ptr != size) {\n\t\t\tint crt = stack[ptr ++];\n\t\t\tfor(Edge e : nodes[crt])\
    \ {\n\t\t\t\tif(depth[e.target] == -1) {\n\t\t\t\t\tdepth[e.target] = depth[crt]\
    \ + 1;\n\t\t\t\t\tedges[e.target] = crt;\n\t\t\t\t\tstack[size ++] = e.target;\n\
    \t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn edges;\n\t}\n\n\tpublic final int cal(int\
    \ u, int v) { // O(logV)\n\t\tFastIO.rangeCheck(u, numNode);\n\t\tFastIO.rangeCheck(v,\
    \ numNode);\n\t\tif(depth[u] > depth[v]) {\n\t\t\tint tmp = u;\n\t\t\tu = v;\n\
    \t\t\tv = tmp;\n\t\t}\n\t\tfor(int k = 0; k < db.log; k ++) {\n\t\t\tif((depth[v]\
    \ - depth[u] & 1 << k) != 0) v = db.next[k][v];\n\t\t}\n\t\tfor(int k = db.log\
    \ - 1; k >= 0; k --) {\n\t\t\tif(u != v && db.next[k][u] != db.next[k][v]) {\n\
    \t\t\t\tu = db.next[k][u];\n\t\t\t\tv = db.next[k][v];\n\t\t\t}\n\t\t}\n\t\tif(u\
    \ != v) {\n\t\t\tu = db.next[0][u];\n\t\t\tv = db.next[0][v];\n\t\t}\n\t\treturn\
    \ u;\n\t}\n}"
  dependsOn:
  - library/FastIO.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/Lca.java
  requiredBy: []
  timestamp: '2023-03-25 01:16:43+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/Lca_test.java
documentation_of: library/Lca.java
layout: document
redirect_from:
- /library/library/Lca.java
- /library/library/Lca.java.html
title: library/Lca.java
---
