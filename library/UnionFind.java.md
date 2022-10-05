---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy:
  - icon: ':heavy_check_mark:'
    path: library/Kruskal.java
    title: library/Kruskal.java
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/UnionFind_test.java
    title: library/UnionFind_test.java
  - icon: ':heavy_check_mark:'
    path: library/UnionFind_uniteAll_test.java
    title: library/UnionFind_uniteAll_test.java
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
    \ library.AbstractGraph;\n\nclass UnionFind { // N=numNode\n\tpublic final int\
    \ n;\n\tprivate final int nodes[]; // non neg: parent idx, neg: - size\n\tpublic\
    \ int numGroups;\n\n\tpublic UnionFind(final int n) { // O(N)\n\t\tSimpleUtil.nonNegativeCheck(n);\n\
    \t\tthis.n = n;\n\t\tnodes = new int[n];\n\t\tnumGroups = n;\n\t\tArrays.fill(nodes,\
    \ -1);\n\t}\n\n\tpublic final void uniteAll(final AbstractNode<? extends AbstractEdge>\
    \ edges) { for(AbstractEdge e : edges) unite(e); } // O(a(N)M)\n\tpublic final\
    \ void uniteAll(final AbstractEdge[] edges) { for(AbstractEdge e : edges) unite(e);\
    \ } // O(a(N)M)\n\tpublic final boolean unite(final AbstractEdge e) { return unite(e.source,\
    \ e.target); }\n\tpublic final boolean unite(final int x, final int y) { // O(a(N))\n\
    \t\tSimpleUtil.rangeCheck(x, n);\n\t\tSimpleUtil.rangeCheck(y, n);\n\t\tint xRoot\
    \ = root(x);\n\t\tint yRoot = root(y);\n\t\tif(xRoot == yRoot) return true;\n\t\
    \tnumGroups --;\n\t\tif(nodes[yRoot] < nodes[xRoot]) {\n\t\t\tnodes[yRoot] +=\
    \ nodes[xRoot];\n\t\t\tnodes[xRoot] = yRoot;\n\t\t}else {\n\t\t\tnodes[xRoot]\
    \ += nodes[yRoot];\n\t\t\tnodes[yRoot] = xRoot;\n\t\t}\n\t\treturn false;\n\t\
    }\n\n\tpublic final int size(final int i) { SimpleUtil.rangeCheck(i, n); return\
    \ - nodes[root(i)]; } // O(a(N))\n\n\tpublic final int root(final int i) { //\
    \ O(a(N))\n\t\tSimpleUtil.rangeCheck(i, n);\n\t\tif(nodes[i] < 0) return i;\n\t\
    \treturn nodes[i] = root(nodes[i]);\n\t}\n\n\tpublic final boolean same(final\
    \ int x, final int y) { SimpleUtil.rangeCheck(x, n); SimpleUtil.rangeCheck(y,\
    \ n); return root(x) == root(y); } // O(a(N))\n\n\tpublic final HashMap<Integer,\
    \ HashSet<Integer>> groups() { // O(N)\n\t\tHashMap<Integer, HashSet<Integer>>\
    \ groups = new HashMap<>();\n\t\tfor(int i = 0; i < n; i ++) {\n\t\t\tint root\
    \ = root(i);\n\t\t\tgroups.putIfAbsent(root, new HashSet<>());\n\t\t\tgroups.get(root).add(i);\n\
    \t\t}\n\t\treturn groups;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/UnionFind.java
  requiredBy:
  - library/Kruskal.java
  timestamp: '2022-10-05 20:31:46+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/UnionFind_uniteAll_test.java
  - library/UnionFind_test.java
documentation_of: library/UnionFind.java
layout: document
redirect_from:
- /library/library/UnionFind.java
- /library/library/UnionFind.java.html
title: library/UnionFind.java
---
