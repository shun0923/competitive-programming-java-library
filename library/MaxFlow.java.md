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
    path: library/MaxFlow_test.java
    title: library/MaxFlow_test.java
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
    \nfinal class MaxFlow { // V=numNode, E=numEdge\n\tpublic final class CapEdge\
    \ {\n\t\tpublic int source, target;\n\t\tpublic long cap;\n\t\tpublic int rev;\n\
    \t\tpublic CapEdge(final int source, final int target, final long cap, final int\
    \ rev) {\n\t\t\tthis.source = source;\n\t\t\tthis.target = target;\n\t\t\tthis.cap\
    \ = cap;\n\t\t\tthis.rev = rev;\n\t\t}\n\t\tpublic long getFlow() { return edges[target][rev].cap;\
    \ }\n\n\t\t@Override public String toString() { return source+\" - \"+cap+\" ->\
    \ \"+target; }\n\t\t@Override public int hashCode() { return Objects.hash(source,\
    \ target); }\n\t\t@Override\n\t\tpublic boolean equals(final Object obj) {\n\t\
    \t\tif(this == obj) return true;\n\t\t\tif(obj == null) return false;\n\t\t\t\
    if(this.getClass() != obj.getClass()) return false;\n\t\t\tCapEdge that = (CapEdge)\
    \ obj;\n\t\t\tif(this.source != that.source) return false;\n\t\t\tif(this.target\
    \ != that.target) return false;\n\t\t\treturn true;\n\t\t}\n\t}\n\n\tpublic final\
    \ int numNode;\n\tpublic final List<CapEdge> edgesList;\n\tprivate final int len[];\n\
    \tpublic final CapEdge edges[][];\n\n\tpublic MaxFlow(final int numNode) { //\
    \ O(1)\n\t\tFastIO.nonNegativeCheck(numNode);\n\t\tthis.numNode = numNode;\n\n\
    \t\tedgesList = new ArrayList<>();\n\t\tlen = new int[numNode];\n\t\tedges = new\
    \ CapEdge[numNode][];\n\t}\n\n\tpublic final int numEdge() { return edgesList.size();\
    \ }\n\n\tpublic final void addAll(final Collection<WeightedEdge> edges) { for(WeightedEdge\
    \ e : edges) add(e); } // O(M)\n\t// O(1)\n\tpublic final int add(final WeightedEdge\
    \ e) { return add(e.source, e.target, e.cost); }\n\tpublic final int add(final\
    \ int source, final int target, final long cap) {\n\t\tFastIO.rangeCheck(source,\
    \ numNode);\n\t\tFastIO.rangeCheck(target, numNode);\n\t\tCapEdge e = new CapEdge(source,\
    \ target, cap, len[target]);\n\t\tlen[source] ++;\n\t\tlen[target] ++;\n\t\tedgesList.add(e);\n\
    \t\treturn edgesList.size() - 1;\n\t}\n\n\tpublic final void changeEdge(final\
    \ int i, final long newCap, final long newFlow) { // O(1)\n\t\tFastIO.rangeCheck(i,\
    \ edgesList.size());\n\t\tFastIO.nonNegativeCheck(newFlow);\n\t\tFastIO.assertion(newFlow\
    \ <= newCap, \"newFlow is larger than newCap.\");\n\t\tCapEdge e = edgesList.get(i);\n\
    \t\tCapEdge er = edges[e.target][e.rev];\n\t\te.cap = newCap - newFlow;\n\t\t\
    er.cap = newFlow;\n\t}\n\n\tprivate final void init() { // O(E)\n\t\tfor(int i\
    \ = 0; i < numNode; i ++) edges[i] = new CapEdge[len[i]];\n\t\tint idx[] = new\
    \ int[numNode];\n\t\tfor(CapEdge e : edgesList) {\n\t\t\tedges[e.target][idx[e.target]\
    \ ++] = new CapEdge(e.target, e.source, 0, idx[e.source]);\n\t\t\tedges[e.source][idx[e.source]\
    \ ++] = e;\n\t\t}\n\t}\n\n\n\tpublic final long maxFlow(final int s, final int\
    \ t) { return flow(s, t, FastIO.INF); } // O(V^2E)\n\tpublic final long flow(final\
    \ int s, final int t, final long flowLimit) {\n\t\tFastIO.rangeCheck(s, numNode);\n\
    \t\tFastIO.rangeCheck(t, numNode);\n\t\tint iter[] = new int[numNode];\n\t\tinit();\n\
    \t\tlong flow = 0;\n\t\twhile(true) {\n\t\t\tlong depth[] = dinicBFS(s, t);\n\t\
    \t\tif(FastIO.isINF(depth[t])) return flow;\n\t\t\tArrays.fill(iter, 0);\n\t\t\
    \tlong f = 0;\n\t\t\tdo {\n\t\t\t\tf = dinicDFS(s, t, flowLimit - flow, depth,\
    \ iter);\n\t\t\t\tflow += f;\n\t\t\t}while(f > 0);\n\t\t}\n\t}\n\tprivate final\
    \ long[] dinicBFS(final int s, final int t) { // O(V)\n\t\tlong depth[] = new\
    \ long[numNode];\n\t\tArrays.fill(depth, FastIO.INF);\n\n\t\tint dq[] = new int[numNode];\n\
    \t\tint size = 0;\n\t\tint ptr = 0;\n\n\t\tdq[size ++] = s;\n\t\tdepth[s] = 0;\n\
    \t\twhile(ptr < size) {\n\t\t\tint crt = dq[ptr ++];\n\t\t\tfor(CapEdge e : edges[crt])\
    \ {\n\t\t\t\tif(e.cap <= 0 || !FastIO.isINF(depth[e.target])) continue;\n\t\t\t\
    \tdepth[e.target] = depth[e.source] + 1;\n\t\t\t\tif(e.target == t) return depth;\n\
    \t\t\t\tdq[size ++] = e.target;\n\t\t\t}\n\t\t}\n\t\treturn depth;\n\t}\n\tprivate\
    \ final long dinicDFS(final int v, final int t, final long f, final long[] depth,\
    \ final int[] iter) { // O(VE)\n\t\tif(v == t) return f;\n\t\tfor(; iter[v] <\
    \ len[v]; iter[v] ++) {\n\t\t\tCapEdge e = edges[v][iter[v]];\n\t\t\tif(e.cap\
    \ <= 0 || depth[e.source] >= depth[e.target]) continue;\n\t\t\tlong d = dinicDFS(e.target,\
    \ t, Math.min(f, e.cap), depth, iter);\n\t\t\tif(d <= 0) continue;\n\t\t\te.cap\
    \ -= d;\n\t\t\tedges[e.target][e.rev].cap += d;\n\t\t\treturn d;\n\t\t}\n\t\t\
    return 0;\n\t}\n\n\t// O(Ef)\n\tpublic final long fordFulkersonMaxFlow(final int\
    \ s, final int t) { return fordFulkersonFlow(s, t, FastIO.INF); }\n\tpublic final\
    \ long fordFulkersonFlow(final int s, final int t, final long flowLimit) {\n\t\
    \tFastIO.rangeCheck(s, numNode);\n\t\tFastIO.rangeCheck(t, numNode);\n\t\tinit();\n\
    \t\tboolean[] used = new boolean[numNode];\n\t\tlong flow = 0;\n\t\twhile(true)\
    \ {\n\t\t\tArrays.fill(used, false);\n\t\t\tlong f = fordFulkersonDFS(s, t, flowLimit\
    \ - flow, used);\n\t\t\tif(f <= 0) return flow;\n\t\t\tflow += f;\n\t\t}\n\t}\n\
    \tprivate final long fordFulkersonDFS(final int v, final int t, final long f,\
    \ final boolean[] used) { // O(V)\n\t\tif(v == t) return f;\n\t\tused[v] = true;\n\
    \t\tfor(CapEdge e : edges[v]) {\n\t\t\tif(e.cap <= 0 || used[e.target]) continue;\n\
    \t\t\tlong d = fordFulkersonDFS(e.target, t, Math.min(f, e.cap), used);\n\t\t\t\
    if(d <= 0) continue;\n\t\t\te.cap -= d;\n\t\t\tedges[e.target][e.rev].cap += d;\n\
    \t\t\treturn d;\n\t\t}\n\t\treturn 0;\n\t}\n\n\tpublic final boolean[] minCut(final\
    \ int s) { // O(V)\n\t\tFastIO.rangeCheck(s, numNode);\n\t\tboolean[] reachable\
    \ = new boolean[numNode];\n\t\tint[] dq = new int[numNode];\n\t\tint ptr = 0;\n\
    \t\tdq[ptr ++] = s;\n\t\treachable[s] = true;\n\t\twhile(ptr > 0) {\n\t\t\tint\
    \ crt = dq[-- ptr];\n\t\t\tfor(CapEdge e : edges[crt]) {\n\t\t\t\tif(reachable[e.target]\
    \ || e.cap <= 0) continue;\n\t\t\t\treachable[e.target] = true;\n\t\t\t\tdq[ptr\
    \ ++] = e.target;\n\t\t\t}\n\t\t}\n\t\treturn reachable;\n\t}\n}"
  dependsOn:
  - library/FastIO.java
  - library/AbstractGraph.java
  isVerificationFile: false
  path: library/MaxFlow.java
  requiredBy: []
  timestamp: '2023-03-25 16:20:34+09:00'
  verificationStatus: LIBRARY_ALL_AC
  verifiedWith:
  - library/MaxFlow_test.java
documentation_of: library/MaxFlow.java
layout: document
redirect_from:
- /library/library/MaxFlow.java
- /library/library/MaxFlow.java.html
title: library/MaxFlow.java
---
