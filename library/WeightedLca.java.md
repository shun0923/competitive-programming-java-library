---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/WeightedLca_test.java
    title: library/WeightedLca_test.java
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 421, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 526, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.util.*;\nimport java.util.function.*;\nimport\
    \ library.SimpleUtil;\nimport library.AbstractGraph;\n\nfinal class WeightedLca\
    \ {\n\tprivate final long id;\n\tprivate final LongBinaryOperator f;\n\tprivate\
    \ final int numNode;\n\tprivate WeightedDoubling db;\n\tpublic final int depth[];\n\
    \n\t// O(VlogV)\n\tpublic WeightedLca(final int numNode, final WeightedNode[]\
    \ nodes, final int root, final long id, final LongBinaryOperator f) {\n\t\tSimpleUtil.nonNegativeCheck(numNode);\n\
    \t\tSimpleUtil.rangeCheck(root, numNode);\n\t\tthis.numNode = numNode;\n\t\tthis.id\
    \ = id;\n\t\tthis.f = f;\n\t\tdepth = new int[numNode];\n\t\tdb = new WeightedDoubling(numNode,\
    \ numNode, id, f, bfs(root, nodes));\n\t}\n\tpublic WeightedLca(final WeightedGraph\
    \ g, final int root, final long id, final LongBinaryOperator f) {\n\t\tthis(g.numNode,\
    \ g.nodes(), root, id, f);\n\t}\n\n\tprivate final WeightedNode bfs(final int\
    \ start, final WeightedNode[] nodes) { // O(V)\n\t\tArrayWeightedNode edges =\
    \ new ArrayWeightedNode(-1);\n\t\tint stack[] = new int[numNode];\n\t\tint ptr\
    \ = 0;\n\t\tint size = 0;\n\n\t\tArrays.fill(depth, -1);\n\t\tdepth[start] = 0;\n\
    \t\tstack[size ++] = 0;\n\t\twhile(ptr != size) {\n\t\t\tint crt = stack[ptr ++];\n\
    \t\t\tfor(WeightedEdge e : nodes[crt]) {\n\t\t\t\tif(depth[e.target] == -1) {\n\
    \t\t\t\t\tdepth[e.target] = depth[crt] + 1;\n\t\t\t\t\tedges.add(e.reverse());\n\
    \t\t\t\t\tstack[size ++] = e.target;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn edges;\n\
    \t}\n\n\tpublic final WeightedEdge cal(int u, int v) { // O(logV)\n\t\tSimpleUtil.rangeCheck(u,\
    \ numNode);\n\t\tSimpleUtil.rangeCheck(v, numNode);\n\t\tif(depth[u] > depth[v])\
    \ {\n\t\t\tint tmp = u;\n\t\t\tu = v;\n\t\t\tv = tmp;\n\t\t}\n\t\tlong cost =\
    \ id;\n\t\tfor(int k = 0; k < db.log; k ++) {\n\t\t\tif((depth[v] - depth[u] &\
    \ 1 << k) != 0) {\n\t\t\t\tcost = f.applyAsLong(cost, db.val[k][v]);\n\t\t\t\t\
    v = db.next[k][v];\n\t\t\t}\n\t\t}\n\t\tfor(int k = db.log - 1; k >= 0; k --)\
    \ {\n\t\t\tif(u != v && db.next[k][u] != db.next[k][v]) {\n\t\t\t\tcost = f.applyAsLong(cost,\
    \ db.val[k][u]);\n\t\t\t\tu = db.next[k][u];\n\t\t\t\tcost = f.applyAsLong(cost,\
    \ db.val[k][v]);\n\t\t\t\tv = db.next[k][v];\n\t\t\t}\n\t\t}\n\t\tif(u != v) {\n\
    \t\t\tcost = f.applyAsLong(cost, db.val[0][u]);\n\t\t\tu = db.next[0][u];\n\t\t\
    \tcost = f.applyAsLong(cost, db.val[0][v]);\n\t\t\tv = db.next[0][v];\n\t\t}\n\
    \t\treturn new WeightedEdge(-1, u, cost);\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/WeightedLca.java
  requiredBy: []
  timestamp: '2022-10-05 21:11:17+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/WeightedLca_test.java
documentation_of: library/WeightedLca.java
layout: document
redirect_from:
- /library/library/WeightedLca.java
- /library/library/WeightedLca.java.html
title: library/WeightedLca.java
---
