---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':warning:'
    path: library/FastIO.java
    title: library/FastIO.java
  - icon: ':x:'
    path: library/Scc.java
    title: library/Scc.java
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
  code: "package library;\n\nimport library.FastIO;\nimport library.AbstractGraph;\n\
    import library.Scc;\n\nclass TwoSat extends ArrayUnweightedGraph {\n\tprivate\
    \ final int n;\n\tprivate final boolean ans[];\n\n\t// O(V)\n\tTwoSat(int n, boolean\
    \ directed) { super(n * 2, directed); this.n = n; ans = new boolean[n]; }\n\t\
    TwoSat(int n) { this(n, true); }\n\n\t// O(1)\n\tpublic final void addClause(int\
    \ i, boolean f, int j, boolean g) {\n\t\tFastIO.rangeCheck(i, n);\n\t\tFastIO.rangeCheck(j,\
    \ n);\n\t\tadd((i << 1) + (f ? 0 : 1), (j << 1) + (g ? 1 : 0));\n\t\tadd((j <<\
    \ 1) + (g ? 0 : 1), (i << 1) + (f ? 1 : 0));\n\t}\n\tpublic final void addImplication(int\
    \ i, boolean f, int j, boolean g) { addClause(i, !f, j, g); }\n\tpublic final\
    \ void addNand(int i, boolean f, int j, boolean g) { addClause(i, !f, j, !g);\
    \ }\n\n\t// O(V+E)\n\tpublic final boolean satisfiable() {\n\t\tint id[] = Scc.calIds(this);\n\
    \t\tfor(int i = 0; i < n; i++) {\n\t\t\tif(id[i << 1] == id[(i << 1) | 1]) return\
    \ false;\n\t\t\tans[i] = id[i << 1] < id[(i << 1) | 1];\n\t\t}\n\t\treturn true;\n\
    \t}\n\tpublic final boolean[] cal() { satisfiable(); return ans; }\n}"
  dependsOn:
  - library/FastIO.java
  - library/AbstractGraph.java
  - library/Scc.java
  isVerificationFile: false
  path: library/TwoSat.java
  requiredBy: []
  timestamp: '2023-03-24 00:57:03+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: library/TwoSat.java
layout: document
redirect_from:
- /library/library/TwoSat.java
- /library/library/TwoSat.java.html
title: library/TwoSat.java
---
