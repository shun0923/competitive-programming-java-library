---
data:
  _extendedDependsOn:
  - icon: ':heavy_check_mark:'
    path: library/AbstractGrid.java
    title: library/AbstractGrid.java
  - icon: ':heavy_check_mark:'
    path: library/GridBfs.java
    title: library/GridBfs.java
  - icon: ':heavy_check_mark:'
    path: library/Solver.java
    title: library/Solver.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0558
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
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0558\n\
    \npackage library;\n\nimport library.Solver;\nimport library.AbstractGrid;\nimport\
    \ library.GridBfs;\n\npublic class GridBfs_test extends Solver {\n\tpublic static\
    \ void main(final String[] args) { main(args, new GridBfs_test()); }\n\n\tpublic\
    \ void solve() {\n\t\tint h = ni();\n\t\tint w = ni();\n\t\tint n = ni();\n\t\t\
    BooleanGrids g = new BooleanGrids(h, w);\n\t\tBooleanGrid s[] = new BooleanGrid[n\
    \ + 1];\n\t\tchar c[][] = nc(h, w);\n\t\tboolean b[][] = new boolean[h][w];\n\t\
    \tfor(int i = 0; i < h; i ++) {\n\t\t\tfor(int j = 0; j < w; j ++) {\n\t\t\t\t\
    b[i][j] = c[i][j] == 'X';\n\t\t\t\tif(c[i][j] == 'S') s[0] = g.get(i, j);\n\t\t\
    \t\tif(isNumber(c[i][j])) s[charToInt(c[i][j])] = g.get(i, j);\n\t\t\t}\n\t\t\
    }\n\t\tg.init(b);\n\n\t\tlong ans = 0;\n\t\tfor(int i = 0; i < n; i ++) ans +=\
    \ GridBfs.dist(g, s[i])[s[i + 1].i];\n\t\tprtln(ans);\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGrid.java
  - library/GridBfs.java
  isVerificationFile: true
  path: library/GridBfs_test.java
  requiredBy: []
  timestamp: '2023-03-26 18:09:04+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/GridBfs_test.java
layout: document
redirect_from:
- /verify/library/GridBfs_test.java
- /verify/library/GridBfs_test.java.html
title: library/GridBfs_test.java
---
