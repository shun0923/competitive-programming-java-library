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
  - icon: ':x:'
    path: library/TemplateRerooting_test.java
    title: library/TemplateRerooting_test.java
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
  code: "package library;\n\nimport java.util.*;\nimport java.util.function.*;\nimport\
    \ library.FastIO;\nimport library.AbstractGraph;\n\nclass TemplateRerooting<T>\
    \ {\n\t@FunctionalInterface\n\tinterface MergeOperator<T> { T apply(T x1, T x2);\
    \ }\n\tinterface AddEdgeOperator<T> { T apply(TemplateEdge<T> e, T x); }\n\tinterface\
    \ AddRootOperator<T> { T apply(int v, T x); }\n\tinterface CreateNodeOperator<T>\
    \ { T apply(int v); }\n\n\tprivate final int numNode;\n\tprivate final ArrayTemplateNode<T>\
    \ nodes[];\n\tprivate final int start;\n\n\tprivate final Supplier<T> eSupplier;\n\
    \tprivate final MergeOperator<T> merge;\n\tprivate final AddEdgeOperator<T> addEdge;\n\
    \tprivate final AddRootOperator<T> addRoot;\n\tprivate final CreateNodeOperator<T>\
    \ createNode;\n\n\tprivate final int parents[];\n\tpublic final T dp[];\n\tpublic\
    \ final T ans[];\n\n\n\t@SuppressWarnings(\"unchecked\")\n\tpublic TemplateRerooting(int\
    \ numNode, ArrayTemplateNode<T>[] nodes, int start, Supplier<T> eSupplier,\n\t\
    \tMergeOperator<T> merge, AddEdgeOperator<T> addEdge, AddRootOperator<T> addRoot,\
    \ CreateNodeOperator<T> createNode) { // O(V)\n\t\tthis.numNode = numNode;\n\t\
    \tthis.nodes = nodes;\n\t\tthis.start = start;\n\t\tthis.eSupplier = eSupplier;\n\
    \t\tthis.merge = merge;\n\t\tthis.addEdge = addEdge;\n\t\tthis.addRoot = addRoot;\n\
    \t\tthis.createNode = createNode;\n\n\t\tparents = new int[numNode];\n\t\tdp =\
    \ (T[]) new Object[numNode];\n\t\tans = (T[]) new Object[numNode];\n\t\tfor(int\
    \ i = 0; i < numNode; i ++) dp[i] = eSupplier.get();\n\t}\n\n\tpublic final void\
    \ cal() { // O(V+E)\n\t\tdfs();\n\t\treroot();\n\t}\n\tpublic final T getDp(int\
    \ i) { FastIO.rangeCheck(i, numNode); return dp[i]; } // O(1)\n\tpublic final\
    \ T get(int i) { FastIO.rangeCheck(i, numNode); return ans[i]; } // O(1)\n\n\t\
    public final void dfs() { // O(V+E)\n\t\tint dq[] = new int[numNode];\n\t\tint\
    \ ptr = 0;\n\t\tint route[] = new int[numNode];\n\t\tint idx = numNode;\n\n\t\t\
    dq[ptr ++] = start;\n\t\tparents[start] = -1;\n\t\twhile(ptr > 0) {\n\t\t\tint\
    \ crt = dq[-- ptr];\n\t\t\troute[-- idx] = crt;\n\t\t\tfor(TemplateEdge<T> e :\
    \ nodes[crt]) {\n\t\t\t\tif(e.target == parents[crt]) continue;\n\t\t\t\tparents[e.target]\
    \ = crt;\n\t\t\t\tdq[ptr ++] = e.target;\n\t\t\t}\n\t\t}\n\t\tfor(int crt : route)\
    \ {\n\t\t\tT tmp = createNode.apply(crt);\n\t\t\tfor(TemplateEdge<T> e : nodes[crt])\
    \ if(e.target != parents[crt]) tmp = merge.apply(tmp, addEdge.apply(e, dp[e.target]));\n\
    \t\t\tdp[crt] = addRoot.apply(crt, tmp);\n\t\t}\n\t}\n\n\t@SuppressWarnings(\"\
    unchecked\")\n\tpublic final void reroot() { // O(V+E)\n\t\tint dq[] = new int[numNode];\n\
    \t\tT rootDq[] = (T[]) new Object[numNode];\n\t\tint ptr = 0;\n\t\tint size =\
    \ 0;\n\n\t\tdq[size ++] = start;\n\t\twhile(ptr < size) {\n\t\t\tint crt = dq[ptr];\n\
    \t\t\tArrayTemplateNode<T> crtNode = nodes[crt];\n\t\t\tint len = crtNode.size();\n\
    \n\t\t\tT dpL[] = (T[]) new Object[len + 1];\n\t\t\tdpL[0] = eSupplier.get();\n\
    \t\t\tfor(int i = 0; i < len; i ++) {\n\t\t\t\tTemplateEdge<T> e = crtNode.get(i);\n\
    \t\t\t\tT tmp = addEdge.apply(e, e.target == parents[crt] ? rootDq[ptr] : dp[e.target]);\n\
    \t\t\t\tdpL[i + 1] = merge.apply(dpL[i], tmp);\n\t\t\t}\n\t\t\tT dpR[] = (T[])\
    \ new Object[len + 1];\n\t\t\tdpR[len] = eSupplier.get();\n\t\t\tfor(int i = len\
    \ - 1; i >= 0; i --) {\n\t\t\t\tTemplateEdge<T> e = crtNode.get(i);\n\t\t\t\t\
    T tmp = addEdge.apply(e, e.target == parents[crt] ? rootDq[ptr] : dp[e.target]);\n\
    \t\t\t\tdpR[i] = merge.apply(dpR[i + 1], tmp);\n\t\t\t}\n\t\t\tans[crt] = addRoot.apply(crt,\
    \ dpL[len]);\n\n\t\t\tint idx = 0;\n\t\t\tfor(TemplateEdge<T> e : crtNode) {\n\
    \t\t\t\tidx ++;\n\t\t\t\tif(e.target == parents[crt]) continue;\n\t\t\t\tT tmp\
    \ = createNode.apply(crt);\n\t\t\t\ttmp = merge.apply(tmp, dpL[idx - 1]);\n\t\t\
    \t\ttmp = merge.apply(tmp, dpR[idx]);\n\t\t\t\trootDq[size] = addRoot.apply(crt,\
    \ tmp);\n\t\t\t\tdq[size ++] = e.target;\n\t\t\t}\n\n\t\t\tptr ++;\n\t\t}\n\t\
    }\n}"
  dependsOn:
  - library/FastIO.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/TemplateRerooting.java
  requiredBy: []
  timestamp: '2023-03-23 19:06:36+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - library/TemplateRerooting_test.java
documentation_of: library/TemplateRerooting.java
layout: document
redirect_from:
- /library/library/TemplateRerooting.java
- /library/library/TemplateRerooting.java.html
title: library/TemplateRerooting.java
---
