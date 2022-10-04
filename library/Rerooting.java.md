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
    path: library/Rerooting_test.java
    title: library/Rerooting_test.java
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
  code: "package library;\n\nimport java.util.*;\nimport java.util.function.*;\nimport\
    \ library.SimpleUtil;\nimport library.AbstractGraph;\n\nclass Rerooting {\n\t\
    @FunctionalInterface\n\tinterface MergeOperator { long apply(long x1, long x2);\
    \ }\n\tinterface AddEdgeOperator { long apply(WeightedEdge e, long x); }\n\tinterface\
    \ AddRootOperator { long apply(int v, long x); }\n\tinterface CreateNodeOperator\
    \ { long apply(int v); }\n\n\tprivate final int numNode;\n\tprivate final ArrayWeightedNode\
    \ nodes[];\n\tprivate final int start;\n\n\tprivate final long id;\n\tprivate\
    \ final MergeOperator merge;\n\tprivate final AddEdgeOperator addEdge;\n\tprivate\
    \ final AddRootOperator addRoot;\n\tprivate final CreateNodeOperator createNode;\n\
    \n\tprivate final int parents[];\n\tpublic final long dp[];\n\tpublic final long\
    \ ans[];\n\n\n\tpublic Rerooting(final int numNode, final ArrayWeightedNode[]\
    \ nodes, final int start, final long id,\n\t\tfinal MergeOperator merge, final\
    \ AddEdgeOperator addEdge, final AddRootOperator addRoot, final CreateNodeOperator\
    \ createNode) { // O(V)\n\t\tthis.numNode = numNode;\n\t\tthis.nodes = nodes;\n\
    \t\tthis.start = start;\n\t\tthis.id = id;\n\t\tthis.merge = merge;\n\t\tthis.addEdge\
    \ = addEdge;\n\t\tthis.addRoot = addRoot;\n\t\tthis.createNode = createNode;\n\
    \n\t\tparents = new int[numNode];\n\t\tdp = new long[numNode];\n\t\tans = new\
    \ long[numNode];\n\t}\n\n\tpublic final long[] cal() { // O(V+E)\n\t\tdfs();\n\
    \t\treturn reroot();\n\t}\n\n\tpublic final long[] dfs() { // O(V+E)\n\t\tint\
    \ dq[] = new int[numNode];\n\t\tint ptr = 0;\n\t\tint route[] = new int[numNode];\n\
    \t\tint idx = numNode;\n\n\t\tdq[ptr ++] = start;\n\t\tparents[start] = -1;\n\t\
    \twhile(ptr > 0) {\n\t\t\tint crt = dq[-- ptr];\n\t\t\troute[-- idx] = crt;\n\t\
    \t\tfor(WeightedEdge e : nodes[crt]) {\n\t\t\t\tif(e.target == parents[crt]) continue;\n\
    \t\t\t\tparents[e.target] = crt;\n\t\t\t\tdq[ptr ++] = e.target;\n\t\t\t}\n\t\t\
    }\n\t\tfor(int crt : route) {\n\t\t\tlong tmp = createNode.apply(crt);\n\t\t\t\
    for(WeightedEdge e : nodes[crt]) if(e.target != parents[crt]) tmp = merge.apply(tmp,\
    \ addEdge.apply(e, dp[e.target]));\n\t\t\tdp[crt] = addRoot.apply(crt, tmp);\n\
    \t\t}\n\t\treturn dp;\n\t}\n\n\tpublic final long[] reroot() { // O(V+E)\n\t\t\
    int dq[] = new int[numNode];\n\t\tlong rootDq[] = new long[numNode];\n\t\tint\
    \ ptr = 0;\n\t\tint size = 0;\n\n\t\tdq[size ++] = start;\n\t\twhile(ptr < size)\
    \ {\n\t\t\tint crt = dq[ptr];\n\t\t\tArrayWeightedNode crtNode = nodes[crt];\n\
    \t\t\tint len = crtNode.size();\n\n\t\t\tlong dpL[] = new long[len + 1];\n\t\t\
    \tdpL[0] = id;\n\t\t\tfor(int i = 0; i < len; i ++) {\n\t\t\t\tWeightedEdge e\
    \ = crtNode.get(i);\n\t\t\t\tlong tmp = addEdge.apply(e, e.target == parents[crt]\
    \ ? rootDq[ptr] : dp[e.target]);\n\t\t\t\tdpL[i + 1] = merge.apply(dpL[i], tmp);\n\
    \t\t\t}\n\t\t\tlong dpR[] = new long[len + 1];\n\t\t\tdpR[len] = id;\n\t\t\tfor(int\
    \ i = len - 1; i >= 0; i --) {\n\t\t\t\tWeightedEdge e = crtNode.get(i);\n\t\t\
    \t\tlong tmp = addEdge.apply(e, e.target == parents[crt] ? rootDq[ptr] : dp[e.target]);\n\
    \t\t\t\tdpR[i] = merge.apply(dpR[i + 1], tmp);\n\t\t\t}\n\t\t\tans[crt] = addRoot.apply(crt,\
    \ dpL[len]);\n\n\t\t\tint idx = 0;\n\t\t\tfor(WeightedEdge e : crtNode) {\n\t\t\
    \t\tidx ++;\n\t\t\t\tif(e.target == parents[crt]) continue;\n\t\t\t\tlong tmp\
    \ = createNode.apply(crt);\n\t\t\t\ttmp = merge.apply(tmp, dpL[idx - 1]);\n\t\t\
    \t\ttmp = merge.apply(tmp, dpR[idx]);\n\t\t\t\trootDq[size] = addRoot.apply(crt,\
    \ tmp);\n\t\t\t\tdq[size ++] = e.target;\n\t\t\t}\n\n\t\t\tptr ++;\n\t\t}\n\t\t\
    return ans;\n\t}\n}"
  dependsOn:
  - library/SimpleUtil.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/Rerooting.java
  requiredBy: []
  timestamp: '2022-10-04 23:03:18+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/Rerooting_test.java
documentation_of: library/Rerooting.java
layout: document
redirect_from:
- /library/library/Rerooting.java
- /library/library/Rerooting.java.html
title: library/Rerooting.java
---
