---
data:
  _extendedDependsOn:
  - icon: ':x:'
    path: library/AbstractGrid.java
    title: library/AbstractGrid.java
  - icon: ':warning:'
    path: library/FastIO.java
    title: library/FastIO.java
  _extendedRequiredBy: []
  _extendedVerifiedWith:
  - icon: ':x:'
    path: library/GridBfs_test.java
    title: library/GridBfs_test.java
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
  code: "package library;\n\nimport java.util.*;\nimport library.FastIO;\nimport library.AbstractGrid;\n\
    \nfinal class GridBfs {\n\t// O(HW)\n\tpublic static final int[] dist(final BooleanGrids\
    \ g, final BooleanGrid start) { return dist(g, start, null); }\n\tpublic static\
    \ final int[] dist(final BooleanGrids g, final BooleanGrid start, final int[]\
    \ prv) {\n\t\tint n = g.h * g.w;\n\t\tint dist[] = new int[n];\n\t\tArrays.fill(dist,\
    \ -1);\n\t\tboolean visited[] = new boolean[n];\n\t\tBooleanGrid dq[] = new BooleanGrid[n];\n\
    \t\tint ptr = 0;\n\t\tint size = 0;\n\t\tif(prv != null) Arrays.fill(prv, -1);\n\
    \n\t\tdist[start.i] = 0;\n\t\tvisited[start.i] = true;\n\t\tdq[size ++] = start;\n\
    \t\twhile(ptr != size) {\n\t\t\tBooleanGrid crt = dq[ptr ++];\n\t\t\tfor(int add\
    \ = 1; add <= 4; add ++) {\n\t\t\t\tBooleanGrid next = g.next(crt, add);\n\t\t\
    \t\tif(next == null || next.b) continue;\n\t\t\t\tif(!visited[next.i]) {\n\t\t\
    \t\t\tdist[next.i] = dist[crt.i] + 1;\n\t\t\t\t\tvisited[next.i] = true;\n\t\t\
    \t\t\tdq[size ++] = next;\n\t\t\t\t\tif(prv != null) prv[next.i] = crt.i;\n\t\t\
    \t\t}\n\t\t\t}\n\t\t}\n\t\treturn dist;\n\t}\n}"
  dependsOn:
  - library/FastIO.java
  - library/AbstractGrid.java
  isVerificationFile: false
  path: library/GridBfs.java
  requiredBy: []
  timestamp: '2023-03-25 18:52:00+09:00'
  verificationStatus: LIBRARY_ALL_WA
  verifiedWith:
  - library/GridBfs_test.java
documentation_of: library/GridBfs.java
layout: document
redirect_from:
- /library/library/GridBfs.java
- /library/library/GridBfs.java.html
title: library/GridBfs.java
---
