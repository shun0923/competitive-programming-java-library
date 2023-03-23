---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':warning:'
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
  code: "package library;\n\nimport java.util.*;\nimport library.AbstractGraph;\n\n\
    class EulerTour {\n\tpublic static int tour[];\n\tpublic static int pos[][];\n\
    \n\tpublic static final <Edge extends AbstractEdge<Edge>> void cal(final AbstractGraph<?\
    \ extends AbstractNode<Edge>, Edge> g, final int start) { cal(g.numNode, g.nodes(),\
    \ start); }\n\tpublic static final void cal(final int numNode, final AbstractNode<?\
    \ extends AbstractEdge>[] nodes, int start) { // O(V)\n\t\ttour = new int[numNode\
    \ * 2];\n\t\tpos = new int[numNode][2];\n\t\tint index = 0;\n\n\t\tDeque<Integer>\
    \ s = new ArrayDeque<>();\n\t\tboolean visited[] = new boolean[numNode];\n\n\t\
    \ts.addFirst(start);\n\n\t\twhile(!s.isEmpty()) {\n\t\t\tint crt = s.removeFirst();\n\
    \t\t\tif(visited[crt]) {\n\t\t\t\tpos[crt][1] = index;\n\t\t\t\ttour[index ++]\
    \ = crt;\n\t\t\t\tcontinue;\n\t\t\t}\n\t\t\tvisited[crt] = true;\n\t\t\tpos[crt][0]\
    \ = index;\n\t\t\ttour[index ++] = crt;\n\t\t\ts.addFirst(crt);\n\t\t\tfor(AbstractEdge\
    \ e : nodes[crt]) {\n\t\t\t\tif(!visited[e.target]) {\n\t\t\t\t\ts.addFirst(e.target);\n\
    \t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n}"
  dependsOn:
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/EulerTour.java
  requiredBy: []
  timestamp: '2023-03-23 23:34:20+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: library/EulerTour.java
layout: document
redirect_from:
- /library/library/EulerTour.java
- /library/library/EulerTour.java.html
title: library/EulerTour.java
---
