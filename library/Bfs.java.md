---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':heavy_check_mark:'
    path: library/PathRestoration.java
    title: library/PathRestoration.java
  - icon: ':warning:'
    path: library/SimpleUtil.java
    title: library/SimpleUtil.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':heavy_check_mark:'
    path: library/Bfs_test.java
    title: library/Bfs_test.java
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
    \ library.AbstractGraph;\nimport library.PathRestoration;\n\nfinal class Bfs {\n\
    \tprivate static int prv[];\n\tprivate static UnweightedEdge prvEdge[];\n\n\t\
    // O(V)\n\tpublic static final int[] dist(UnweightedGraph g, int start) { return\
    \ dist(g, start, false); }\n\tpublic static final int[] dist(UnweightedGraph g,\
    \ int start, boolean memoize) { return dist(g.nodes(), start, memoize); }\n\t\
    public static final int[] dist(UnweightedNode[] nodes, int start) { return dist(nodes,\
    \ start, false); }\n\tpublic static final int[] dist(UnweightedNode[] nodes, int\
    \ start, boolean memoize) {\n\t\tint numNode = nodes.length;\n\t\tint dist[] =\
    \ new int[numNode];\n\t\tArrays.fill(dist, -1);\n\t\tboolean visited[] = new boolean[numNode];\n\
    \t\tint dq[] = new int[numNode];\n\t\tint ptr = 0;\n\t\tint size = 0;\n\t\tif(memoize)\
    \ {\n\t\t\tprv = new int[numNode];\n\t\t\tArrays.fill(prv, -1);\n\t\t\tprvEdge\
    \ = new UnweightedEdge[numNode];\n\t\t}\n\n\t\tdq[size ++] = start;\n\t\tdist[start]\
    \ = 0;\n\t\tvisited[start] = true;\n\t\twhile(ptr != size) {\n\t\t\tint crt =\
    \ dq[ptr ++];\n\t\t\tfor(UnweightedEdge e : nodes[crt]) {\n\t\t\t\tif(!visited[e.target])\
    \ {\n\t\t\t\t\tdist[e.target] = dist[e.source] + 1;\n\t\t\t\t\tvisited[e.target]\
    \ = true;\n\t\t\t\t\tdq[size ++] = e.target;\n\t\t\t\t\tif(memoize) {\n\t\t\t\t\
    \t\tprv[e.target] = e.source;\n\t\t\t\t\t\tprvEdge[e.target] = e;\n\t\t\t\t\t\
    }\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\treturn dist;\n\t}\n\tpublic static final int[]\
    \ path(final int start, final int goal) { return PathRestoration.path(prv, start,\
    \ goal); }\n\tpublic static final ArrayUnweightedNode pathEdge(final int start,\
    \ final int goal) { return PathRestoration.pathEdge(new ArrayUnweightedNode(-1),\
    \ prv, prvEdge, start, goal); }\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  - library/PathRestoration.java
  isVerificationFile: false
  path: library/Bfs.java
  requiredBy: []
  timestamp: '2022-10-05 15:32:30+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/Bfs_test.java
documentation_of: library/Bfs.java
layout: document
redirect_from:
- /library/library/Bfs.java
- /library/library/Bfs.java.html
title: library/Bfs.java
---
