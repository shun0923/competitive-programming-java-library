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
    path: library/WeightedBfs_test.java
    title: library/WeightedBfs_test.java
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
    \nfinal class WeightedBfs {\n\t// O(V)\n\tpublic static final long[] dist(final\
    \ AbstractGraph<? extends WeightedNode, WeightedEdge> g, final int start) { return\
    \ dist(g, start, null, null); }\n\tpublic static final long[] dist(final AbstractGraph<?\
    \ extends WeightedNode, WeightedEdge> g, final int start, final int[] prv) { return\
    \ dist(g, start, prv, null); }\n\tpublic static final long[] dist(final AbstractGraph<?\
    \ extends WeightedNode, WeightedEdge> g, final int start, final int[] prv, final\
    \ WeightedEdge[] prvEdge) { return dist(g.nodes(), start, prv, prvEdge); }\n\t\
    public static final long[] dist(final WeightedNode[] nodes, final int start) {\
    \ return dist(nodes, start, null, null); }\n\tpublic static final long[] dist(final\
    \ WeightedNode[] nodes, final int start, final int[] prv) { return dist(nodes,\
    \ start, prv, null); }\n\tpublic static final long[] dist(final WeightedNode[]\
    \ nodes, final int start, final int[] prv, final WeightedEdge[] prvEdge) {\n\t\
    \tint numNode = nodes.length;\n\t\tlong dist[] = new long[numNode];\n\t\tArrays.fill(dist,\
    \ -1);\n\t\tboolean visited[] = new boolean[numNode];\n\t\tint dq[] = new int[numNode];\n\
    \t\tint ptr = 0;\n\t\tint size = 0;\n\t\tif(prv != null) Arrays.fill(prv, -1);\n\
    \n\t\tdq[size ++] = start;\n\t\tdist[start] = 0;\n\t\tvisited[start] = true;\n\
    \t\twhile(ptr != size) {\n\t\t\tint crt = dq[ptr ++];\n\t\t\tfor(WeightedEdge\
    \ e : nodes[crt]) {\n\t\t\t\tif(!visited[e.target]) {\n\t\t\t\t\tdist[e.target]\
    \ = dist[e.source] + e.cost;\n\t\t\t\t\tvisited[e.target] = true;\n\t\t\t\t\t\
    dq[size ++] = e.target;\n\t\t\t\t\tif(prv != null) prv[e.target] = e.source;\n\
    \t\t\t\t\tif(prvEdge != null) prvEdge[e.target] = e;\n\t\t\t\t}\n\t\t\t}\n\t\t\
    }\n\t\treturn dist;\n\t}\n}"
  dependsOn:
  - library/FastIO.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/WeightedBfs.java
  requiredBy: []
  timestamp: '2023-03-25 00:20:39+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/WeightedBfs_test.java
documentation_of: library/WeightedBfs.java
layout: document
redirect_from:
- /library/library/WeightedBfs.java
- /library/library/WeightedBfs.java.html
title: library/WeightedBfs.java
---
