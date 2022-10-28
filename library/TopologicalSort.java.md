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
    path: library/TopologicalSort_test.java
    title: library/TopologicalSort_test.java
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
  code: "package library;\n\nimport java.util.*;\nimport library.SimpleUtil;\nimport\
    \ library.AbstractGraph;\n\nfinal class TopologicalSort {\n\t// O(E+V)\n\tpublic\
    \ static final <Edge extends AbstractEdge<Edge>> int[] sort(AbstractGraph<? extends\
    \ AbstractNode<Edge>, Edge> g) { return sort(g.nodes(), g.edges()); }\n\tpublic\
    \ static final <Edge extends AbstractEdge<Edge>> int[] sort(AbstractNode<Edge>[]\
    \ nodes, AbstractNode<Edge> edges) {\n\t\tint numNode = nodes.length;\n\t\tint\
    \ dq[] = new int[numNode];\n\t\tint ptr = 0;\n\t\tint size = 0;\n\t\tint deg[]\
    \ = new int[numNode];\n\t\tArrays.fill(deg, 0);\n\t\tfor(AbstractEdge e : edges)\
    \ deg[e.target] ++;\n\t\tfor(int i = 0; i < numNode; i ++) if(deg[i] == 0) dq[size\
    \ ++] = i;\n\t\tint ans[] = new int[numNode];\n\t\tint idx = 0;\n\t\twhile(ptr\
    \ != size) {\n\t\t\tint crt = dq[ptr ++];\n\t\t\tans[idx ++] = crt;\n\t\t\tfor(AbstractEdge\
    \ e : nodes[crt]) if(-- deg[e.target] == 0) dq[size ++] = e.target;\n\t\t}\n\t\
    \treturn idx == numNode ? ans : null;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/TopologicalSort.java
  requiredBy: []
  timestamp: '2022-10-05 21:11:17+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/TopologicalSort_test.java
documentation_of: library/TopologicalSort.java
layout: document
redirect_from:
- /library/library/TopologicalSort.java
- /library/library/TopologicalSort.java.html
title: library/TopologicalSort.java
---
